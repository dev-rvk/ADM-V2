package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
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
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSelectionHandles.android.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\t\u001a8\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0000\u001a \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a$\u0010\u001f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DefaultSelectionHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/runtime/Composer;I)V", "HandlePopup", "position", "Landroidx/compose/ui/geometry/Offset;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "HandlePopup-ULxng0E", "(JLandroidx/compose/foundation/text/selection/HandleReferencePoint;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "SelectionHandle-8fL75-g", "(JZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isHandleLtrDirection", "areHandlesCrossed", "isLeft", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidSelectionHandles_androidKt {
    /* renamed from: SelectionHandle-8fL75-g, reason: not valid java name */
    public static final void m874SelectionHandle8fL75g(final long position, final boolean isStartHandle, final ResolvedTextDirection direction, final boolean handlesCrossed, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        HandleReferencePoint handleReferencePoint;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer3 = $composer.startRestartGroup(-616295642);
        ComposerKt.sourceInformation($composer3, "C(SelectionHandle)P(5:c#ui.geometry.Offset,3,1,2,4)69@2795L823:AndroidSelectionHandles.android.kt#eksfi3");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(position) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(isStartHandle) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(direction) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(handlesCrossed) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changed(modifier) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 131072 : 65536;
        }
        final int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-616295642, $dirty2, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:53)");
            }
            boolean isLeft = isLeft(isStartHandle, direction, handlesCrossed);
            if (isLeft) {
                handleReferencePoint = HandleReferencePoint.TopRight;
            } else {
                handleReferencePoint = HandleReferencePoint.TopLeft;
            }
            $composer2 = $composer3;
            m873HandlePopupULxng0E(position, handleReferencePoint, ComposableLambdaKt.composableLambda($composer3, 732099485, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C:AndroidSelectionHandles.android.kt#eksfi3");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(732099485, $changed2, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:69)");
                        }
                        if (function2 == null) {
                            $composer4.startReplaceableGroup(386443790);
                            ComposerKt.sourceInformation($composer4, "73@3009L405,71@2918L645");
                            Modifier modifier2 = modifier;
                            Object key1$iv = Boolean.valueOf(isStartHandle);
                            Object key2$iv = Offset.m2699boximpl(position);
                            final boolean z = isStartHandle;
                            final long j = position;
                            int i = (($dirty2 >> 3) & 14) | (($dirty2 << 3) & 112);
                            $composer4.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation($composer4, "CC(remember)P(1,2):Composables.kt#9igjgp");
                            boolean invalid$iv$iv = $composer4.changed(key1$iv) | $composer4.changed(key2$iv);
                            Object it$iv$iv = $composer4.rememberedValue();
                            if (!invalid$iv$iv) {
                                Object key1$iv2 = Composer.INSTANCE.getEmpty();
                                if (it$iv$iv != key1$iv2) {
                                    value$iv$iv = it$iv$iv;
                                    $composer4.endReplaceableGroup();
                                    AndroidSelectionHandles_androidKt.DefaultSelectionHandle(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) value$iv$iv, 1, null), isStartHandle, direction, handlesCrossed, $composer4, ($dirty2 & 7168) | ($dirty2 & 112) | ($dirty2 & 896));
                                    $composer4.endReplaceableGroup();
                                }
                            }
                            value$iv$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Handle handle;
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertyKey<SelectionHandleInfo> selectionHandleInfoKey = SelectionHandlesKt.getSelectionHandleInfoKey();
                                    if (z) {
                                        handle = Handle.SelectionStart;
                                    } else {
                                        handle = Handle.SelectionEnd;
                                    }
                                    semantics.set(selectionHandleInfoKey, new SelectionHandleInfo(handle, j, null));
                                }
                            };
                            $composer4.updateRememberedValue(value$iv$iv);
                            $composer4.endReplaceableGroup();
                            AndroidSelectionHandles_androidKt.DefaultSelectionHandle(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) value$iv$iv, 1, null), isStartHandle, direction, handlesCrossed, $composer4, ($dirty2 & 7168) | ($dirty2 & 112) | ($dirty2 & 896));
                            $composer4.endReplaceableGroup();
                        } else {
                            $composer4.startReplaceableGroup(386444465);
                            ComposerKt.sourceInformation($composer4, "88@3593L9");
                            function2.invoke($composer4, Integer.valueOf(($dirty2 >> 15) & 14));
                            $composer4.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ($dirty2 & 14) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$2
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
                AndroidSelectionHandles_androidKt.m874SelectionHandle8fL75g(position, isStartHandle, direction, handlesCrossed, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final void DefaultSelectionHandle(final Modifier modifier, final boolean isStartHandle, final ResolvedTextDirection direction, final boolean handlesCrossed, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Composer $composer2 = $composer.startRestartGroup(47957398);
        ComposerKt.sourceInformation($composer2, "C(DefaultSelectionHandle)P(3,2)101@3820L137:AndroidSelectionHandles.android.kt#eksfi3");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(isStartHandle) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(direction) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(handlesCrossed) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(47957398, $changed, -1, "androidx.compose.foundation.text.selection.DefaultSelectionHandle (AndroidSelectionHandles.android.kt:95)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m533sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), isStartHandle, direction, handlesCrossed), $composer2, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1
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
                AndroidSelectionHandles_androidKt.DefaultSelectionHandle(Modifier.this, isStartHandle, direction, handlesCrossed, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final Modifier drawSelectionHandle(Modifier $this$drawSelectionHandle, final boolean isStartHandle, final ResolvedTextDirection direction, final boolean handlesCrossed) {
        Intrinsics.checkNotNullParameter($this$drawSelectionHandle, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return ComposedModifierKt.composed$default($this$drawSelectionHandle, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-1538687176);
                ComposerKt.sourceInformation($composer, "C112@4160L7,114@4226L847:AndroidSelectionHandles.android.kt#eksfi3");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1538687176, $changed, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:111)");
                }
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final long handleColor = ((SelectionColors) consume).getSelectionHandleColor();
                Modifier.Companion companion = Modifier.INSTANCE;
                Object[] keys$iv = {Color.m2939boximpl(handleColor), Boolean.valueOf(isStartHandle), direction, Boolean.valueOf(handlesCrossed)};
                final boolean z = isStartHandle;
                final ResolvedTextDirection resolvedTextDirection = direction;
                final boolean z2 = handlesCrossed;
                $composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv = false;
                for (Object key$iv : keys$iv) {
                    invalid$iv |= $composer.changed(key$iv);
                }
                Object value$iv$iv = $composer.rememberedValue();
                if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope drawWithCache) {
                            Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
                            float radius = Size.m2779getWidthimpl(drawWithCache.m2616getSizeNHjbRc()) / 2.0f;
                            final ImageBitmap handleImage = AndroidSelectionHandles_androidKt.createHandleImage(drawWithCache, radius);
                            final ColorFilter colorFilter = ColorFilter.Companion.m2990tintxETnrds$default(ColorFilter.INSTANCE, handleColor, 0, 2, null);
                            final boolean z3 = z;
                            final ResolvedTextDirection resolvedTextDirection2 = resolvedTextDirection;
                            final boolean z4 = z2;
                            return drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.1
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
                                    boolean isLeft;
                                    Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                                    onDrawWithContent.drawContent();
                                    isLeft = AndroidSelectionHandles_androidKt.isLeft(z3, resolvedTextDirection2, z4);
                                    if (isLeft) {
                                        ContentDrawScope $this$scale_u2dFgt4K4Q_u24default$iv = onDrawWithContent;
                                        ImageBitmap imageBitmap = handleImage;
                                        ColorFilter colorFilter2 = colorFilter;
                                        long pivot$iv = $this$scale_u2dFgt4K4Q_u24default$iv.mo3491getCenterF1C5BW0();
                                        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$scale_u2dFgt4K4Q_u24default$iv.getDrawContext();
                                        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
                                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                                        DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                                        $this$scale_Fgt4K4Q_u24lambda_u242$iv.mo3424scale0AR0LA0(-1.0f, 1.0f, pivot$iv);
                                        DrawScope.m3477drawImagegbVJVH8$default($this$scale_u2dFgt4K4Q_u24default$iv, imageBitmap, 0L, 0.0f, null, colorFilter2, 0, 46, null);
                                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                        $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
                                        return;
                                    }
                                    DrawScope.m3477drawImagegbVJVH8$default(onDrawWithContent, handleImage, 0L, 0.0f, null, colorFilter, 0, 46, null);
                                }
                            });
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv);
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

    public static final ImageBitmap createHandleImage(CacheDrawScope $this$createHandleImage, float radius) {
        ImageBitmap imageBitmap;
        Canvas canvas;
        CanvasDrawScope drawScope;
        Intrinsics.checkNotNullParameter($this$createHandleImage, "<this>");
        int edge = ((int) Math.ceil(radius)) * 2;
        ImageBitmap imageBitmap2 = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas2 = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope drawScope2 = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap2 == null || canvas2 == null || edge > imageBitmap2.getWidth() || edge > imageBitmap2.getHeight()) {
            ImageBitmap imageBitmap3 = ImageBitmapKt.m3171ImageBitmapx__hDU$default(edge, edge, ImageBitmapConfig.INSTANCE.m3165getAlpha8_sVssgQ(), false, null, 24, null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap3);
            Canvas canvas3 = CanvasKt.Canvas(imageBitmap3);
            HandleImageCache.INSTANCE.setCanvas(canvas3);
            imageBitmap = imageBitmap3;
            canvas = canvas3;
        } else {
            imageBitmap = imageBitmap2;
            canvas = canvas2;
        }
        if (drawScope2 != null) {
            drawScope = drawScope2;
        } else {
            CanvasDrawScope drawScope3 = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(drawScope3);
            drawScope = drawScope3;
        }
        LayoutDirection layoutDirection$iv = $this$createHandleImage.getLayoutDirection();
        long size$iv = androidx.compose.ui.geometry.SizeKt.Size(imageBitmap.getWidth(), imageBitmap.getHeight());
        CanvasDrawScope this_$iv = drawScope;
        CanvasDrawScope.DrawParams drawParams = this_$iv.getDrawParams();
        Density prevDensity$iv = drawParams.getDensity();
        LayoutDirection prevLayoutDirection$iv = drawParams.getLayoutDirection();
        Canvas prevCanvas$iv = drawParams.getCanvas();
        long prevSize$iv = drawParams.getSize();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240$iv.setDensity($this$createHandleImage);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setLayoutDirection(layoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setCanvas(canvas);
        $this$draw_yzxVdVo_u24lambda_u240$iv.m3416setSizeuvyYCjk(size$iv);
        canvas.save();
        CanvasDrawScope $this$createHandleImage_u24lambda_u240 = this_$iv;
        DrawScope.m3487drawRectnJ9OG0$default($this$createHandleImage_u24lambda_u240, Color.INSTANCE.m2975getBlack0d7_KjU(), 0L, $this$createHandleImage_u24lambda_u240.mo3492getSizeNHjbRc(), 0.0f, null, null, BlendMode.INSTANCE.m2866getClear0nO6VwU(), 58, null);
        DrawScope.m3487drawRectnJ9OG0$default($this$createHandleImage_u24lambda_u240, ColorKt.Color(4278190080L), Offset.INSTANCE.m2726getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(radius, radius), 0.0f, null, null, 0, 120, null);
        DrawScope.m3474drawCircleVaOC9Bg$default($this$createHandleImage_u24lambda_u240, ColorKt.Color(4278190080L), radius, OffsetKt.Offset(radius, radius), 0.0f, null, null, 0, 120, null);
        canvas.restore();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.m3416setSizeuvyYCjk(prevSize$iv);
        return imageBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /* renamed from: HandlePopup-ULxng0E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m873HandlePopupULxng0E(final long r25, final androidx.compose.foundation.text.selection.HandleReferencePoint r27, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m873HandlePopupULxng0E(long, androidx.compose.foundation.text.selection.HandleReferencePoint, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isLeft(boolean isStartHandle, ResolvedTextDirection direction, boolean handlesCrossed) {
        if (isStartHandle) {
            return isHandleLtrDirection(direction, handlesCrossed);
        }
        return !isHandleLtrDirection(direction, handlesCrossed);
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection direction, boolean areHandlesCrossed) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return (direction == ResolvedTextDirection.Ltr && !areHandlesCrossed) || (direction == ResolvedTextDirection.Rtl && areHandlesCrossed);
    }
}
