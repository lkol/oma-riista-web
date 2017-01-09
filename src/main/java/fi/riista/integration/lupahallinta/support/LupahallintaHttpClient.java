package fi.riista.integration.lupahallinta.support;

import fi.riista.config.web.BasicAuthenticationClientInterceptor;
import fi.riista.integration.lupahallinta.LupahallintaImportConfig;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.Path;

import static java.util.Collections.singletonList;

@Component
public class LupahallintaHttpClient {

    private static final Logger LOG = LoggerFactory.getLogger(LupahallintaHttpClient.class);

    private static final DateTimeFormatter PATTERN = DateTimeFormat.forPattern("yyyyMMddHHmmss");

    @Resource
    private LupahallintaImportConfig config;

    @Resource
    private ClientHttpRequestFactory requestFactory;

    public Path downloadClubCSV(final Path outputFile) {
        LOG.info("Going to fetch clubs using uri:{}", config.getClubUri());

        return createRestTemplate().execute(config.getClubUri(), HttpMethod.GET, null, request -> {
            try (final FileOutputStream fos = new FileOutputStream(outputFile.toFile());
                 final BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                IOUtils.copy(request.getBody(), bos);
                bos.flush();
            }

            return outputFile;
        });
    }

    public Reader getPermits(DateTime after) {
        final URI uri = getPermitUri(after);

        LOG.info("Going to fetch permits using uri:{}", uri);

        return new StringReader(createRestTemplate()
                .execute(uri, HttpMethod.GET, null, r -> IOUtils.toString(r.getBody(), "ISO-8859-1")));
    }

    private URI getPermitUri(DateTime after) {
        return UriComponentsBuilder.fromUri(config.getPermitUri())
                .queryParam("after", PATTERN.print(after))
                .queryParam("permittypes", config.getPermitTypes())
                .build().toUri();
    }

    private RestTemplate createRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate(requestFactory);

        restTemplate.setInterceptors(singletonList(
                new BasicAuthenticationClientInterceptor(config.getUsername(), config.getPassword())
        ));

        return restTemplate;
    }
}
