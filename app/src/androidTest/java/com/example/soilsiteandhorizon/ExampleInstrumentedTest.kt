package com.example.soilsiteandhorizon

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.soilsiteandhorizon.data.SoilParameterDao
import com.example.soilsiteandhorizon.data.SoilParameterDatabase
import com.example.soilsiteandhorizon.data.SoilParameterEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var soilParameterDao: SoilParameterDao
    private lateinit var db: SoilParameterDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, SoilParameterDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        soilParameterDao = db.soilParameterDao()
    }

//    @After
//    @Throws(IOException::class)
//    fun deleteDb() {
//        db.close()
//    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetTodo() = runBlocking {
        val soilItem = SoilParameterEntity(
            id = 1,
            soilId = 1,
            subSoilId = "1",
            combId = "1",
            title = "Number Form",
            description = " "
        )
        soilParameterDao.insert(soilItem)
        val oneItem = soilParameterDao.getSoilParameterById(1)
        assertEquals(oneItem?.id, 1)
    }
}