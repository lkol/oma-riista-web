/**
 * Tempo Net API
 * Tempo Net API provides HTTP-based API for controlling Tempo Platform.   <table> <style type=\"text/css\" scoped> th, tr, td  { border: 0px; }</style> <thead>     <tr>             <th colspan=\"7\">Interface hierarchy</th>     </tr> </thead> <body> <tr>     <td>project</td>     <td>+</td>     <td>template</td> </tr> <tr>     <td></td>     <td>|</td>     <td></td> </tr> <tr>     <td></td>     <td>+</td>     <td>company</td>     <td>-</td>     <td>short number</td>     <td>-</td>     <td>call tracking</td> </tr> </tbody> </table> 
 *
 * OpenAPI spec version: 1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.nsftele.tempo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * EmailCallTrackingReport
 */

public class EmailCallTrackingReport extends CallTrackingReport  {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("message_template_id")
  private String messageTemplateId = null;

  @JsonProperty("subject_template_id")
  private String subjectTemplateId = null;

  public EmailCallTrackingReport email(String email) {
    this.email = email;
    return this;
  }

   /**
   * recipient of the call tracking report
   * @return email
  **/
  @ApiModelProperty(example = "null", required = true, value = "recipient of the call tracking report")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmailCallTrackingReport messageTemplateId(String messageTemplateId) {
    this.messageTemplateId = messageTemplateId;
    return this;
  }

   /**
   * identifier of the template used to construct the body of the email
   * @return messageTemplateId
  **/
  @ApiModelProperty(example = "null", required = true, value = "identifier of the template used to construct the body of the email")
  public String getMessageTemplateId() {
    return messageTemplateId;
  }

  public void setMessageTemplateId(String messageTemplateId) {
    this.messageTemplateId = messageTemplateId;
  }

  public EmailCallTrackingReport subjectTemplateId(String subjectTemplateId) {
    this.subjectTemplateId = subjectTemplateId;
    return this;
  }

   /**
   * identifier of the template used to construct the subject of the email
   * @return subjectTemplateId
  **/
  @ApiModelProperty(example = "null", required = true, value = "identifier of the template used to construct the subject of the email")
  public String getSubjectTemplateId() {
    return subjectTemplateId;
  }

  public void setSubjectTemplateId(String subjectTemplateId) {
    this.subjectTemplateId = subjectTemplateId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailCallTrackingReport emailCallTrackingReport = (EmailCallTrackingReport) o;
    return Objects.equals(this.email, emailCallTrackingReport.email) &&
        Objects.equals(this.messageTemplateId, emailCallTrackingReport.messageTemplateId) &&
        Objects.equals(this.subjectTemplateId, emailCallTrackingReport.subjectTemplateId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, messageTemplateId, subjectTemplateId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailCallTrackingReport {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    messageTemplateId: ").append(toIndentedString(messageTemplateId)).append("\n");
    sb.append("    subjectTemplateId: ").append(toIndentedString(subjectTemplateId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

