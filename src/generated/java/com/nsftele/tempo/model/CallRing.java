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
 * CallRing
 */

public class CallRing   {
  @JsonProperty("company_id")
  private String companyId = null;

  public CallRing companyId(String companyId) {
    this.companyId = companyId;
    return this;
  }

   /**
   * identifier of call ring's parent company
   * @return companyId
  **/
  @ApiModelProperty(example = "null", required = true, value = "identifier of call ring's parent company")
  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallRing callRing = (CallRing) o;
    return Objects.equals(this.companyId, callRing.companyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallRing {\n");
    
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
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

