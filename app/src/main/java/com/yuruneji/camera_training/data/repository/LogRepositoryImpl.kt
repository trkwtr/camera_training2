package com.yuruneji.camera_training.data.repository

import com.yuruneji.camera_training.data.local.db.LogDao
import com.yuruneji.camera_training.data.local.db.LogEntity
import com.yuruneji.camera_training.domain.repository.LogRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * @author toru
 * @version 1.0
 */
class LogRepositoryImpl @Inject constructor(
    private val logDao: LogDao
) : LogRepository {
    override fun log(date: LocalDateTime): Flow<List<LogEntity>> {
        return logDao.get(date)
    }

    override fun log(date: LocalDateTime, priority: IntArray): Flow<List<LogEntity>> {
        return logDao.get(date, priority)
    }

    override fun log(from: LocalDateTime, to: LocalDateTime, priority: IntArray): Flow<List<LogEntity>> {
        return logDao.get(from, to, priority)
    }
}
