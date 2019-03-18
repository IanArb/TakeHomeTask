package com.ianarbuckle.codingproject.ui.carsdetail.interactor

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import com.google.common.truth.Truth.assertThat
import com.ianarbuckle.codingproject.data.TotalCharge
import com.ianarbuckle.codingproject.data.VehAvail
import com.ianarbuckle.codingproject.data.VehMakeModel
import com.ianarbuckle.codingproject.data.Vehicle
import com.ianarbuckle.codingproject.ui.utils.TestUtils.getAvailableVehicle
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when` as whenever
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */
class CarsDetailInteractorTest {

    private lateinit var interactor: CarsDetailInteractor

    @Mock
    private lateinit var activity: Activity

    @Mock
    private lateinit var intent: Intent

    private lateinit var vehAvail: VehAvail

    @Before
    fun setup() {
        initMocks(this)

        interactor = DefaultCarsDetailInteractor(activity)
    }

    @Test
    fun `verify that vehicle object retrieved is not empty or null`() {
        whenever(activity.intent).thenReturn(intent)
        vehAvail = getAvailableVehicle()
        whenever(intent.getParcelableExtra<Parcelable>("vehicle")).thenReturn(vehAvail)

        assertThat(interactor.getVehicle()).isNotNull()
    }
}