// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package top.zcwfeng.android_mlkit.java.cloudtextrecognition;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import top.zcwfeng.android_mlkit.common.GraphicOverlay;
import top.zcwfeng.android_mlkit.common.GraphicOverlay.Graphic;

/**
 * Graphic instance for rendering TextBlock position, size, and ID within an associated graphic
 * overlay view.
 */
public class CloudDocumentTextGraphic extends Graphic {
  private static final int TEXT_COLOR = Color.WHITE;
  private static final float TEXT_SIZE = 54.0f;
  private static final float STROKE_WIDTH = 4.0f;

  private final Paint rectPaint;
  private final Paint textPaint;
  private final FirebaseVisionDocumentText.Symbol symbol;
  private final GraphicOverlay overlay;

  CloudDocumentTextGraphic(GraphicOverlay overlay, FirebaseVisionDocumentText.Symbol symbol) {
    super(overlay);

    this.symbol = symbol;
    this.overlay = overlay;

    rectPaint = new Paint();
    rectPaint.setColor(TEXT_COLOR);
    rectPaint.setStyle(Paint.Style.STROKE);
    rectPaint.setStrokeWidth(STROKE_WIDTH);

    textPaint = new Paint();
    textPaint.setColor(TEXT_COLOR);
    textPaint.setTextSize(TEXT_SIZE);
  }

  /** Draws the text block annotations for position, size, and raw value on the supplied canvas. */
  @Override
  public void draw(Canvas canvas) {
    if (symbol == null) {
      throw new IllegalStateException("Attempting to draw a null text.");
    }

        Rect rect = symbol.getBoundingBox();
        canvas.drawRect(rect, rectPaint);
        canvas.drawText(symbol.getText(), rect.left, rect.bottom, textPaint);
  }
}
