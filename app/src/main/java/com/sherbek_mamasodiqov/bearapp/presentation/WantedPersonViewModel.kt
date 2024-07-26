package com.sherbek_mamasodiqov.bearapp.presentation

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.sherbek_mamasodiqov.bearapp.data.local.WantedPersonEntity
import com.sherbek_mamasodiqov.bearapp.data.mappers.toWantedPerson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class WantedPersonViewModel @Inject constructor(
    pager : Pager<Int,WantedPersonEntity>
): ViewModel() {
    val wantedPeoplePagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toWantedPerson() }
        }
        .cachedIn(viewModelScope)
}