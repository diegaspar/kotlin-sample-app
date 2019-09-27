/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vmadalin.dynamicfeatures.characterslist.ui.detail

import com.vmadalin.dynamicfeatures.characterslist.ui.detail.model.CharacterDetail

sealed class CharacterDetailViewState {

    object Loading : CharacterDetailViewState()
    data class Success(val data: CharacterDetail) : CharacterDetailViewState()
    data class Error(val throwable: Throwable) : CharacterDetailViewState()

    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error

    fun data(): CharacterDetail? = if (this is Success) this.data else null
}