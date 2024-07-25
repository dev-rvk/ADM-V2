package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidMultiParagraphDraw.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aa\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aW\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"drawMultiParagraph", "", "Landroidx/compose/ui/text/MultiParagraph;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawMultiParagraph-7AXcY_I", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "drawParagraphs", "drawParagraphs-7AXcY_I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidMultiParagraphDrawKt {
    /* renamed from: drawMultiParagraph-7AXcY_I, reason: not valid java name */
    public static final void m4951drawMultiParagraph7AXcY_I(MultiParagraph drawMultiParagraph, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(drawMultiParagraph, "$this$drawMultiParagraph");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        canvas.save();
        if (drawMultiParagraph.getParagraphInfoList$ui_text_release().size() <= 1) {
            m4953drawParagraphs7AXcY_I(drawMultiParagraph, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
        } else if (brush instanceof SolidColor) {
            m4953drawParagraphs7AXcY_I(drawMultiParagraph, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
        } else if (brush instanceof ShaderBrush) {
            List $this$fastForEach$iv = drawMultiParagraph.getParagraphInfoList$ui_text_release();
            int size = $this$fastForEach$iv.size();
            float height = 0.0f;
            float width = 0.0f;
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                ParagraphInfo it = (ParagraphInfo) item$iv;
                height += it.getParagraph().getHeight();
                width = Math.max(width, it.getParagraph().getWidth());
            }
            Shader shader = ((ShaderBrush) brush).mo2918createShaderuvyYCjk(SizeKt.Size(width, height));
            Matrix matrix = new Matrix();
            shader.getLocalMatrix(matrix);
            List $this$fastForEach$iv2 = drawMultiParagraph.getParagraphInfoList$ui_text_release();
            int index$iv2 = 0;
            for (int size2 = $this$fastForEach$iv2.size(); index$iv2 < size2; size2 = size2) {
                Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                ParagraphInfo it2 = (ParagraphInfo) item$iv2;
                it2.getParagraph().mo4590painthn5TExg(canvas, BrushKt.ShaderBrush(shader), alpha, shadow, decoration, drawStyle, blendMode);
                canvas.translate(0.0f, it2.getParagraph().getHeight());
                matrix.setTranslate(0.0f, -it2.getParagraph().getHeight());
                shader.setLocalMatrix(matrix);
                index$iv2++;
            }
        }
        canvas.restore();
    }

    /* renamed from: drawParagraphs-7AXcY_I, reason: not valid java name */
    private static final void m4953drawParagraphs7AXcY_I(MultiParagraph $this$drawParagraphs_u2d7AXcY_I, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        List $this$fastForEach$iv = $this$drawParagraphs_u2d7AXcY_I.getParagraphInfoList$ui_text_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ParagraphInfo it = (ParagraphInfo) item$iv;
            it.getParagraph().mo4590painthn5TExg(canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0.0f, it.getParagraph().getHeight());
        }
    }
}
