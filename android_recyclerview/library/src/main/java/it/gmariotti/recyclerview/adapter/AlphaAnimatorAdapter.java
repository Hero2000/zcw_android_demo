/*
 * ******************************************************************************
 *   Copyright (c) 2015 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */
package it.gmariotti.recyclerview.adapter;

import android.animation.Animator;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Author Gabriele Mariotti
 */
public class AlphaAnimatorAdapter<T extends RecyclerView.ViewHolder> extends AnimatorAdapter<T> {

    public AlphaAnimatorAdapter(RecyclerView.Adapter<T> adapter, RecyclerView recyclerView) {
        super(adapter, recyclerView);
    }

    @NonNull
    @Override
    public Animator[] getAnimators(@NonNull View view) {
        return new Animator[0];
    }
}
