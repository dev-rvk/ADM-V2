package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: TextPainter.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001ai\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001ak\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0083\u0001\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001am\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020/2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001a)\u00102\u001a\u000203*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00066"}, d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextPainterKt {
    /* renamed from: drawText-JFhB2K4, reason: not valid java name */
    public static final void m4705drawTextJFhB2K4(DrawScope drawText, TextMeasurer textMeasurer, AnnotatedString text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> placeholders, long size, int blendMode) {
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        TextLayoutResult textLayoutResult = TextMeasurer.m4702measurexDpz5zY$default(textMeasurer, text, style, overflow, softWrap, maxLines, placeholders, m4713textLayoutConstraintsv_w8tDc(drawText, size, topLeft), drawText.getLayoutDirection(), drawText, null, false, 1536, null);
        DrawContext $this$withTransform_u24lambda_u246$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_JFhB2K4_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_JFhB2K4_u24lambda_u240.translate(Offset.m2710getXimpl(topLeft), Offset.m2711getYimpl(topLeft));
        clip($this$drawText_JFhB2K4_u24lambda_u240, textLayoutResult);
        textLayoutResult.getMultiParagraph().m4616paintLG529CI(drawText.getDrawContext().getCanvas(), (r14 & 2) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : 0L, (r14 & 4) != 0 ? null : null, (r14 & 8) != 0 ? null : null, (r14 & 16) == 0 ? null : null, (r14 & 32) != 0 ? DrawScope.INSTANCE.m3493getDefaultBlendMode0nO6VwU() : blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: drawText-TPWCCtM, reason: not valid java name */
    public static final void m4709drawTextTPWCCtM(DrawScope drawText, TextMeasurer textMeasurer, String text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, long size, int blendMode) {
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        TextLayoutResult textLayoutResult = TextMeasurer.m4702measurexDpz5zY$default(textMeasurer, new AnnotatedString(text, null, null, 6, null), style, overflow, softWrap, maxLines, null, m4713textLayoutConstraintsv_w8tDc(drawText, size, topLeft), drawText.getLayoutDirection(), drawText, null, false, 1568, null);
        DrawContext $this$withTransform_u24lambda_u246$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_TPWCCtM_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_TPWCCtM_u24lambda_u242.translate(Offset.m2710getXimpl(topLeft), Offset.m2711getYimpl(topLeft));
        clip($this$drawText_TPWCCtM_u24lambda_u242, textLayoutResult);
        textLayoutResult.getMultiParagraph().m4616paintLG529CI(drawText.getDrawContext().getCanvas(), (r14 & 2) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : 0L, (r14 & 4) != 0 ? null : null, (r14 & 8) != 0 ? null : null, (r14 & 16) == 0 ? null : null, (r14 & 32) != 0 ? DrawScope.INSTANCE.m3493getDefaultBlendMode0nO6VwU() : blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: drawText-d8-rzKo, reason: not valid java name */
    public static final void m4711drawTextd8rzKo(DrawScope drawText, TextLayoutResult textLayoutResult, long color, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle newDrawStyle = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext $this$withTransform_u24lambda_u246$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_d8_rzKo_u24lambda_u244 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_d8_rzKo_u24lambda_u244.translate(Offset.m2710getXimpl(topLeft), Offset.m2711getYimpl(topLeft));
        clip($this$drawText_d8_rzKo_u24lambda_u244, textLayoutResult);
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        if (brush != null) {
            if (color == Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                textLayoutResult.getMultiParagraph().m4618painthn5TExg(drawText.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration, newDrawStyle, blendMode);
                $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
            }
        }
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        Canvas canvas = drawText.getDrawContext().getCanvas();
        long $this$takeOrElse_u2dDxMtmZc$iv = color;
        if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU())) {
            $this$takeOrElse_u2dDxMtmZc$iv = textLayoutResult.getLayoutInput().getStyle().m4747getColor0d7_KjU();
        }
        multiParagraph.m4616paintLG529CI(canvas, TextDrawStyleKt.m5108modulateDxMtmZc($this$takeOrElse_u2dDxMtmZc$iv, alpha), newShadow, newTextDecoration, newDrawStyle, blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: drawText-LVfH_YU, reason: not valid java name */
    public static final void m4707drawTextLVfH_YU(DrawScope drawText, TextLayoutResult textLayoutResult, Brush brush, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle newDrawStyle = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext $this$withTransform_u24lambda_u246$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_LVfH_YU_u24lambda_u247 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_LVfH_YU_u24lambda_u247.translate(Offset.m2710getXimpl(topLeft), Offset.m2711getYimpl(topLeft));
        clip($this$drawText_LVfH_YU_u24lambda_u247, textLayoutResult);
        textLayoutResult.getMultiParagraph().m4618painthn5TExg(drawText.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration, newDrawStyle, blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
    }

    private static final void clip(DrawTransform $this$clip, TextLayoutResult textLayoutResult) {
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.m5130equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m5139getVisiblegIe3tQ8())) {
            DrawTransform.m3543clipRectN_I0leg$default($this$clip, 0.0f, 0.0f, IntSize.m5378getWidthimpl(textLayoutResult.getSize()), IntSize.m5377getHeightimpl(textLayoutResult.getSize()), 0, 16, null);
        }
    }

    /* renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m4713textLayoutConstraintsv_w8tDc(DrawScope $this$textLayoutConstraints_u2dv_w8tDc, long size, long topLeft) {
        int minWidth;
        int maxWidth;
        int minHeight;
        int maxHeight;
        boolean z = true;
        boolean isWidthNaN = ((size > Size.INSTANCE.m2787getUnspecifiedNHjbRc() ? 1 : (size == Size.INSTANCE.m2787getUnspecifiedNHjbRc() ? 0 : -1)) == 0) || Float.isNaN(Size.m2779getWidthimpl(size));
        if (isWidthNaN) {
            minWidth = 0;
            maxWidth = MathKt.roundToInt((float) Math.ceil(Size.m2779getWidthimpl($this$textLayoutConstraints_u2dv_w8tDc.mo3492getSizeNHjbRc()) - Offset.m2710getXimpl(topLeft)));
        } else {
            int fixedWidth = MathKt.roundToInt((float) Math.ceil(Size.m2779getWidthimpl(size)));
            minWidth = fixedWidth;
            maxWidth = fixedWidth;
        }
        if ((size == Size.INSTANCE.m2787getUnspecifiedNHjbRc() ? 1 : 0) == 0 && !Float.isNaN(Size.m2776getHeightimpl(size))) {
            z = false;
        }
        boolean isHeightNaN = z;
        if (isHeightNaN) {
            minHeight = 0;
            maxHeight = MathKt.roundToInt((float) Math.ceil(Size.m2776getHeightimpl($this$textLayoutConstraints_u2dv_w8tDc.mo3492getSizeNHjbRc()) - Offset.m2711getYimpl(topLeft)));
        } else {
            int fixedHeight = MathKt.roundToInt((float) Math.ceil(Size.m2776getHeightimpl(size)));
            minHeight = fixedHeight;
            maxHeight = fixedHeight;
        }
        return ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight);
    }
}
