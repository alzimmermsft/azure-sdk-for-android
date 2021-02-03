// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.rest.annotation.Fluent;
import com.azure.core.serde.SerdeToPojo;
import com.azure.core.serde.SerdeProperty;

/** Provides parameter values to a tag scoring function. */
@Fluent
public final class TagScoringParameters {
    /*
     * The name of the parameter passed in search queries to specify the list
     * of tags to compare against the target field.
     */
    @SerdeProperty(value = "tagsParameter")
    private String tagsParameter;

    /**
     * Creates an instance of TagScoringParameters class.
     *
     * @param tagsParameter the tagsParameter value to set.
     */
    @SerdeToPojo
    public TagScoringParameters(@SerdeProperty(value = "tagsParameter") String tagsParameter) {
        this.tagsParameter = tagsParameter;
    }

    /**
     * Get the tagsParameter property: The name of the parameter passed in search queries to specify the list of tags to
     * compare against the target field.
     *
     * @return the tagsParameter value.
     */
    public String getTagsParameter() {
        return this.tagsParameter;
    }
}