/*
 * Copyright 2014 Toxic Bakery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.easy.ui.viewpager.transforms

import android.view.View

open class FlipVerticalTransformer : ABaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val rotation = -180f * position

        page.alpha = if (rotation > 90f || rotation < -90f) 0f else 1f
        page.pivotX = page.width * 0.5f
        page.pivotY = page.height * 0.5f
        page.rotationX = rotation
    }

    override fun onPostTransform(page: View, position: Float) {
        super.onPostTransform(page, position)
        page.visibility = if (position > -0.5f && position < 0.5f) View.VISIBLE else View.INVISIBLE
    }
}
