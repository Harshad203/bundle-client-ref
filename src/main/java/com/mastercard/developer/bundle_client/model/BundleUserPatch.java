/*
 * Bundle Profile API
 * MC product bundle profile
 *
 * The version of the OpenAPI document: 1.0
 * Contact: Digital_Enablement_Team_3@mastercard.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.mastercard.developer.bundle_client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.mastercard.developer.bundle_client.model.PatchDocument;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * BundleUserPatch
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T15:18:38.136+05:30[Asia/Calcutta]")
public class BundleUserPatch {
  public static final String SERIALIZED_NAME_PATCH = "patch";
  @SerializedName(SERIALIZED_NAME_PATCH)
  private List<PatchDocument> patch = null;


  public BundleUserPatch patch(List<PatchDocument> patch) {
    
    this.patch = patch;
    return this;
  }

  public BundleUserPatch addPatchItem(PatchDocument patchItem) {
    if (this.patch == null) {
      this.patch = new ArrayList<>();
    }
    this.patch.add(patchItem);
    return this;
  }

   /**
   * Get patch
   * @return patch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<PatchDocument> getPatch() {
    return patch;
  }



  public void setPatch(List<PatchDocument> patch) {
    this.patch = patch;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BundleUserPatch bundleUserPatch = (BundleUserPatch) o;
    return Objects.equals(this.patch, bundleUserPatch.patch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patch);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BundleUserPatch {\n");
    sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
