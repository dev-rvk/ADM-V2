package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.HandleReferencePoint;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidCursorHandle.android.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u0015\u001a\f\u0010\u0016\u001a\u00020\u000e*\u00020\u000eH\u0000\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "Sqrt2", "", "CursorHandle", "", "handlePosition", "Landroidx/compose/ui/geometry/Offset;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CursorHandle-ULxng0E", "(JLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "drawCursorHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight = Dp.m5218constructorimpl(25);
    private static final float CursorHandleWidth;
    private static final float Sqrt2 = 1.4142135f;

    static {
        float arg0$iv = CursorHandleHeight;
        CursorHandleWidth = Dp.m5218constructorimpl(Dp.m5218constructorimpl(arg0$iv * 2.0f) / 2.4142137f);
    }

    public static final float getCursorHandleHeight() {
        return CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return CursorHandleWidth;
    }

    /* renamed from: CursorHandle-ULxng0E, reason: not valid java name */
    public static final void m740CursorHandleULxng0E(final long handlePosition, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(-5185995);
        ComposerKt.sourceInformation($composer2, "C(CursorHandle)P(1:c#ui.geometry.Offset,2)43@1674L256:AndroidCursorHandle.android.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(handlePosition) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-5185995, $dirty2, -1, "androidx.compose.foundation.text.CursorHandle (AndroidCursorHandle.android.kt:38)");
            }
            AndroidSelectionHandles_androidKt.m873HandlePopupULxng0E(handlePosition, HandleReferencePoint.TopMiddle, ComposableLambdaKt.composableLambda($composer2, -1458480226, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C:AndroidCursorHandle.android.kt#423gt5");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1458480226, $changed2, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:46)");
                        }
                        if (function2 == null) {
                            $composer3.startReplaceableGroup(1275643833);
                            ComposerKt.sourceInformation($composer3, "48@1835L40");
                            AndroidCursorHandle_androidKt.DefaultCursorHandle(modifier, $composer3, ($dirty2 >> 3) & 14);
                            $composer3.endReplaceableGroup();
                        } else {
                            $composer3.startReplaceableGroup(1275643903);
                            ComposerKt.sourceInformation($composer3, "50@1905L9");
                            function2.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
                            $composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty2 & 14) | 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$2
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

            public final void invoke(Composer composer, int i) {
                AndroidCursorHandle_androidKt.m740CursorHandleULxng0E(handlePosition, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final void DefaultCursorHandle(final Modifier modifier, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(694251107);
        ComposerKt.sourceInformation($composer2, "C(DefaultCursorHandle)58@2028L79:AndroidCursorHandle.android.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(694251107, $changed, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:57)");
            }
            SpacerKt.Spacer(drawCursorHandle(SizeKt.m533sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight)), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$DefaultCursorHandle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                AndroidCursorHandle_androidKt.DefaultCursorHandle(Modifier.this, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final Modifier drawCursorHandle(Modifier $this$drawCursorHandle) {
        Intrinsics.checkNotNullParameter($this$drawCursorHandle, "<this>");
        return ComposedModifierKt.composed$default($this$drawCursorHandle, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-2126899193);
                ComposerKt.sourceInformation($composer, "C62@2212L7,64@2278L602:AndroidCursorHandle.android.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2126899193, $changed, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:61)");
                }
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final long handleColor = ((SelectionColors) consume).getSelectionHandleColor();
                Modifier.Companion companion = Modifier.INSTANCE;
                Object key1$iv = Color.m2939boximpl(handleColor);
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(key1$iv);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope drawWithCache) {
                            Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
                            final float radius = Size.m2779getWidthimpl(drawWithCache.m2616getSizeNHjbRc()) / 2.0f;
                            final ImageBitmap imageBitmap = AndroidSelectionHandles_androidKt.createHandleImage(drawWithCache, radius);
                            final ColorFilter colorFilter = ColorFilter.Companion.m2990tintxETnrds$default(ColorFilter.INSTANCE, handleColor, 0, 2, null);
                            return drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                    invoke2(contentDrawScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ContentDrawScope onDrawWithContent) {
                                    Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                                    onDrawWithContent.drawContent();
                                    ContentDrawScope $this$withTransform$iv = onDrawWithContent;
                                    float f = radius;
                                    ImageBitmap imageBitmap2 = imageBitmap;
                                    ColorFilter colorFilter2 = colorFilter;
                                    DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
                                    long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo3417getSizeNHjbRc();
                                    $this$withTransform_u24lambda_u246$iv.getCanvas().save();
                                    DrawTransform $this$invoke_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
                                    DrawTransform.translate$default($this$invoke_u24lambda_u240, f, 0.0f, 2, null);
                                    $this$invoke_u24lambda_u240.mo3423rotateUv8p0NA(45.0f, Offset.INSTANCE.m2726getZeroF1C5BW0());
                                    DrawScope.m3477drawImagegbVJVH8$default($this$withTransform$iv, imageBitmap2, 0L, 0.0f, null, colorFilter2, 0, 46, null);
                                    $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                                    $this$withTransform_u24lambda_u246$iv.mo3418setSizeuvyYCjk(previousSize$iv);
                                }
                            });
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                Modifier then = composed.then(DrawModifierKt.drawWithCache(companion, (Function1) value$iv$iv));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return then;
            }
        }, 1, null);
    }
}
