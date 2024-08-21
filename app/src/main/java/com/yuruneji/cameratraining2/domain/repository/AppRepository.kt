package com.yuruneji.cameratraining2.domain.repository

import com.yuruneji.cameratraining2.data.remote.AppRequest
import com.yuruneji.cameratraining2.data.remote.AppResponse
import okhttp3.MultipartBody

/**
 * @author toru
 * @version 1.0
 */
interface AppRepository {
    suspend fun faceAuth(request: AppRequest): AppResponse
    suspend fun log(log: MultipartBody.Part): AppResponse
}
