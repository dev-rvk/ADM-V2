package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.vector.VectorProperty;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorPainter.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0099\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a£\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\"2@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a&\u0010%\u001a\u00020\u0003*\u00020&2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030(¢\u0006\u0002\b)H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006*"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", HintConstants.AUTOFILL_HINT_NAME, "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* renamed from: rememberVectorPainter-mlNsNFs, reason: not valid java name */
    public static final VectorPainter m3589rememberVectorPaintermlNsNFs(float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, String name, long tintColor, int tintBlendMode, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        float viewportHeight2;
        String name2;
        long tintColor2;
        int tintBlendMode2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(-964365210);
        ComposerKt.sourceInformation($composer, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)83@3597L207:VectorPainter.kt#huu6hf");
        float viewportWidth2 = (i & 4) != 0 ? Float.NaN : viewportWidth;
        if ((i & 8) == 0) {
            viewportHeight2 = viewportHeight;
        } else {
            viewportHeight2 = Float.NaN;
        }
        if ((i & 16) == 0) {
            name2 = name;
        } else {
            name2 = RootGroupName;
        }
        if ((i & 32) == 0) {
            tintColor2 = tintColor;
        } else {
            tintColor2 = Color.INSTANCE.m2985getUnspecified0d7_KjU();
        }
        if ((i & 64) == 0) {
            tintBlendMode2 = tintBlendMode;
        } else {
            tintBlendMode2 = BlendMode.INSTANCE.m2891getSrcIn0nO6VwU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:73)");
        }
        VectorPainter m3590rememberVectorPaintervIP8VLU = m3590rememberVectorPaintervIP8VLU(defaultWidth, defaultHeight, viewportWidth2, viewportHeight2, name2, tintColor2, tintBlendMode2, false, content, $composer, ($changed & 14) | 12582912 | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (($changed << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m3590rememberVectorPaintervIP8VLU;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0151  */
    /* renamed from: rememberVectorPainter-vIP8VLU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.graphics.vector.VectorPainter m3590rememberVectorPaintervIP8VLU(float r21, float r22, float r23, float r24, java.lang.String r25, long r26, int r28, boolean r29, kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.m3590rememberVectorPaintervIP8VLU(float, float, float, float, java.lang.String, long, int, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.graphics.vector.VectorPainter");
    }

    public static final VectorPainter rememberVectorPainter(final ImageVector image, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(image, "image");
        $composer.startReplaceableGroup(1413834416);
        ComposerKt.sourceInformation($composer, "C(rememberVectorPainter)158@6529L424:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:157)");
        }
        VectorPainter m3590rememberVectorPaintervIP8VLU = m3590rememberVectorPaintervIP8VLU(image.getDefaultWidth(), image.getDefaultHeight(), image.getViewportWidth(), image.getViewportHeight(), image.getName(), image.getTintColor(), image.getTintBlendMode(), image.getAutoMirror(), ComposableLambdaKt.composableLambda($composer, 1873274766, true, new Function4<Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2, Composer composer, Integer num) {
                invoke(f.floatValue(), f2.floatValue(), composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f, float f2, Composer $composer2, int $changed2) {
                ComposerKt.sourceInformation($composer2, "C167@6908L37:VectorPainter.kt#huu6hf");
                if (($changed2 & 11) == 2 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1873274766, $changed2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous> (VectorPainter.kt:167)");
                }
                VectorPainterKt.RenderVectorGroup(ImageVector.this.getRoot(), null, $composer2, 0, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), $composer, 100663296, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m3590rememberVectorPaintervIP8VLU;
    }

    private static final void mirror(DrawScope $this$mirror, Function1<? super DrawScope, Unit> function1) {
        long pivot$iv = $this$mirror.mo3491getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$mirror.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
        $this$scale_Fgt4K4Q_u24lambda_u242$iv.mo3424scale0AR0LA0(-1.0f, 1.0f, pivot$iv);
        function1.invoke($this$mirror);
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
    }

    public static final void RenderVectorGroup(final VectorGroup group, Map<String, ? extends VectorConfig> map, Composer $composer, final int $changed, final int i) {
        final Map configs;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(group, "group");
        Composer $composer3 = $composer.startRestartGroup(-446179233);
        ComposerKt.sourceInformation($composer3, "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(group) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 16;
        }
        int $dirty2 = $dirty;
        if (i2 == 2 && ($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            configs = map;
            $composer2 = $composer3;
        } else {
            Map configs2 = i2 != 0 ? MapsKt.emptyMap() : map;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446179233, $changed, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:327)");
            }
            Iterator<VectorNode> it = group.iterator();
            while (it.hasNext()) {
                final VectorNode vectorNode = it.next();
                if (vectorNode instanceof VectorPath) {
                    $composer3.startReplaceableGroup(-326285735);
                    ComposerKt.sourceInformation($composer3, "334@12154L1719");
                    VectorConfig vectorConfig = configs2.get(((VectorPath) vectorNode).getName());
                    if (vectorConfig == null) {
                        vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                        };
                    }
                    VectorConfig config = vectorConfig;
                    Composer $composer4 = $composer3;
                    VectorComposeKt.m3583Path9cdaXJ4((List) config.getOrDefault(VectorProperty.PathData.INSTANCE, ((VectorPath) vectorNode).getPathData()), ((VectorPath) vectorNode).getPathFillType(), ((VectorPath) vectorNode).getName(), (Brush) config.getOrDefault(VectorProperty.Fill.INSTANCE, ((VectorPath) vectorNode).getFill()), ((Number) config.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getFillAlpha()))).floatValue(), (Brush) config.getOrDefault(VectorProperty.Stroke.INSTANCE, ((VectorPath) vectorNode).getStroke()), ((Number) config.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getStrokeAlpha()))).floatValue(), ((Number) config.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getStrokeLineWidth()))).floatValue(), ((VectorPath) vectorNode).getStrokeLineCap(), ((VectorPath) vectorNode).getStrokeLineJoin(), ((VectorPath) vectorNode).getStrokeLineMiter(), ((Number) config.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getTrimPathStart()))).floatValue(), ((Number) config.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getTrimPathEnd()))).floatValue(), ((Number) config.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getTrimPathOffset()))).floatValue(), $composer4, 8, 0, 0);
                    $composer4.endReplaceableGroup();
                    configs2 = configs2;
                    $composer3 = $composer4;
                    it = it;
                } else {
                    Iterator<VectorNode> it2 = it;
                    final Map configs3 = configs2;
                    Composer $composer5 = $composer3;
                    if (vectorNode instanceof VectorGroup) {
                        $composer5.startReplaceableGroup(-326283877);
                        ComposerKt.sourceInformation($composer5, "379@14012L1368");
                        VectorConfig config2 = configs3.get(((VectorGroup) vectorNode).getName());
                        if (config2 == null) {
                            config2 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                            };
                        }
                        VectorComposeKt.Group(((VectorGroup) vectorNode).getName(), ((Number) config2.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getRotation()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getPivotX()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getPivotY()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getScaleX()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getScaleY()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getTranslationX()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getTranslationY()))).floatValue(), (List) config2.getOrDefault(VectorProperty.PathData.INSTANCE, ((VectorGroup) vectorNode).getClipPathData()), ComposableLambdaKt.composableLambda($composer5, 1450046638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer6, int $changed2) {
                                ComposerKt.sourceInformation($composer6, "C414@15310L56:VectorPainter.kt#huu6hf");
                                if (($changed2 & 11) == 2 && $composer6.getSkipping()) {
                                    $composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1450046638, $changed2, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:413)");
                                }
                                VectorPainterKt.RenderVectorGroup((VectorGroup) VectorNode.this, configs3, $composer6, 64, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), $composer5, 939524096, 0);
                        $composer5.endReplaceableGroup();
                        configs2 = configs3;
                        $composer3 = $composer5;
                        it = it2;
                    } else {
                        $composer5.startReplaceableGroup(-326282407);
                        $composer5.endReplaceableGroup();
                        configs2 = configs3;
                        $composer3 = $composer5;
                        it = it2;
                    }
                }
            }
            configs = configs2;
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) {
                VectorPainterKt.RenderVectorGroup(VectorGroup.this, configs, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
