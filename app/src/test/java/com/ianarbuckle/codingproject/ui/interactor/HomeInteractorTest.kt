package com.ianarbuckle.codingproject.ui.interactor

import android.app.Activity
import android.content.res.Resources
import com.google.common.truth.Truth.assertThat
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.Customer
import com.ianarbuckle.codingproject.parser.GsonParser
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when` as whenever
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Ian Arbuckle on 10/01/2019.
 *
 */

class HomeInteractorTest  {

    private lateinit var interactor: HomeInteractor

    @Mock
    private lateinit var activity: Activity

    @Mock
    private lateinit var parser: GsonParser

    @Mock
    private lateinit var resources: Resources

    @Before
    fun setup() {
        initMocks(this)
        interactor = DefaultHomeInteractor(activity, parser)
    }

    @Ignore
    @Test
    fun `verify when ordered customers list is not null or empty`() {
        val list = ArrayList<Customer>().apply {
            add(Customer(1, "Ian", 52.986375, -6.043701))
        }
        whenever(activity.resources).thenReturn(resources)
        whenever(parser.parseJson("")).thenReturn(list)

        assertThat(interactor.fetchCustomersWithinDistance()).isNotEmpty()
    }




}