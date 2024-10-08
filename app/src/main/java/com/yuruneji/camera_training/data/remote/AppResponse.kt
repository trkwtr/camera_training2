package com.yuruneji.camera_training.data.remote

import com.yuruneji.camera_training.domain.model.AppResponseModel

/**
 * @author toru
 * @version 1.0
 */
data class AppResponse(
    val result: Int,
    val name: String,
)

fun AppResponse.toConvert(): AppResponseModel {
    return AppResponseModel(
        result = result,
        name = name,
    )
}
