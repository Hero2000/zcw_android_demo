/*
 * ******************************************************************************
 *   Copyright (c) 2014-2015 Gabriele Mariotti.
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
package it.gmariotti.recyclerview.itemanimator;

import android.view.View;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class ScaleInOutItemAnimator extends BaseItemAnimator {

    private float DEFAULT_SCALE_INITIAL = 0.6f;

    private float mInitialScaleX = DEFAULT_SCALE_INITIAL;
    private float mInitialScaleY = DEFAULT_SCALE_INITIAL;

    private float mEndScaleX = DEFAULT_SCALE_INITIAL;
    private float mEndScaleY = DEFAULT_SCALE_INITIAL;

    private float mOriginalScaleX;
    private float mOriginalScaleY;

    public ScaleInOutItemAnimator(RecyclerView recyclerView) {
        super(recyclerView);
    }

    protected void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);
        mRemoveAnimations.add(holder);
        animation.setDuration(getRemoveDuration())
                .alpha(0)
                .scaleX(0)
                .scaleY(0)
                .setListener(new VpaListenerAdapter() {
                    @Override
                    public void onAnimationStart(View view) {
                        dispatchRemoveStarting(holder);
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        animation.setListener(null);
                        ViewCompat.setAlpha(view, 1);
                        ViewCompat.setScaleX(view, 0);
                        ViewCompat.setScaleY(view, 0);
                        dispatchRemoveFinished(holder);
                        mRemoveAnimations.remove(holder);
                        dispatchFinishedWhenDone();
                    }
                }).start();
    }

    @Override
    protected void prepareAnimateAdd(RecyclerView.ViewHolder holder) {
        retrieveOriginalScale(holder);
        ViewCompat.setScaleX(holder.itemView, 0);
        ViewCompat.setScaleY(holder.itemView, 0);
    }


    protected void animateAddImpl(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);
        mAddAnimations.add(holder);
        animation.scaleX(1)
                .scaleY(1)
                .alpha(1)
                .setDuration(getAddDuration())
                .setListener(new VpaListenerAdapter() {
                    @Override
                    public void onAnimationStart(View view) {
                        dispatchAddStarting(holder);
                    }

                    @Override
                    public void onAnimationCancel(View view) {
                        ViewCompat.setScaleX(view, 1);
                        ViewCompat.setScaleY(view, 1);
                        ViewCompat.setAlpha(view, 1);
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        animation.setListener(null);
                        ViewCompat.setAlpha(view, 1);
                        ViewCompat.setScaleX(view, 1);
                        ViewCompat.setScaleY(view, 1);
                        dispatchAddFinished(holder);
                        mAddAnimations.remove(holder);
                        dispatchFinishedWhenDone();
                    }
                }).start();
    }

    private void retrieveOriginalScale(RecyclerView.ViewHolder holder) {
        mOriginalScaleX = ViewCompat.getScaleX(holder.itemView);
        mOriginalScaleY = ViewCompat.getScaleY(holder.itemView);
    }
}
