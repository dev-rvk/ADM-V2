package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorCompose.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a©\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Group", "", HintConstants.AUTOFILL_HINT_NAME, "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Group(java.lang.String r27, float r28, float r29, float r30, float r31, float r32, float r33, float r34, java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m3583Path9cdaXJ4(final List<? extends PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset, Composer $composer, final int $changed, final int $changed1, final int i) {
        int pathFillType2;
        String name2;
        Brush fill2;
        float fillAlpha2;
        Brush stroke2;
        float strokeAlpha2;
        float strokeLineWidth2;
        int strokeLineCap2;
        int strokeLineJoin2;
        float strokeLineMiter2;
        float trimPathStart2;
        float trimPathEnd2;
        float trimPathOffset2;
        Intrinsics.checkNotNullParameter(pathData, "pathData");
        Composer $composer2 = $composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation($composer2, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)115@5068L876:VectorCompose.kt#huu6hf");
        if ((i & 2) != 0) {
            pathFillType2 = VectorKt.getDefaultFillType();
        } else {
            pathFillType2 = pathFillType;
        }
        if ((i & 4) == 0) {
            name2 = name;
        } else {
            name2 = "";
        }
        if ((i & 8) == 0) {
            fill2 = fill;
        } else {
            fill2 = null;
        }
        if ((i & 16) == 0) {
            fillAlpha2 = fillAlpha;
        } else {
            fillAlpha2 = 1.0f;
        }
        if ((i & 32) == 0) {
            stroke2 = stroke;
        } else {
            stroke2 = null;
        }
        if ((i & 64) == 0) {
            strokeAlpha2 = strokeAlpha;
        } else {
            strokeAlpha2 = 1.0f;
        }
        if ((i & 128) == 0) {
            strokeLineWidth2 = strokeLineWidth;
        } else {
            strokeLineWidth2 = 0.0f;
        }
        if ((i & 256) == 0) {
            strokeLineCap2 = strokeLineCap;
        } else {
            strokeLineCap2 = VectorKt.getDefaultStrokeLineCap();
        }
        if ((i & 512) == 0) {
            strokeLineJoin2 = strokeLineJoin;
        } else {
            strokeLineJoin2 = VectorKt.getDefaultStrokeLineJoin();
        }
        if ((i & 1024) == 0) {
            strokeLineMiter2 = strokeLineMiter;
        } else {
            strokeLineMiter2 = 4.0f;
        }
        if ((i & 2048) == 0) {
            trimPathStart2 = trimPathStart;
        } else {
            trimPathStart2 = 0.0f;
        }
        if ((i & 4096) == 0) {
            trimPathEnd2 = trimPathEnd;
        } else {
            trimPathEnd2 = 1.0f;
        }
        if ((i & 8192) == 0) {
            trimPathOffset2 = trimPathOffset;
        } else {
            trimPathOffset2 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, $changed, $changed1, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:99)");
        }
        final Function0 factory$iv = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PathComponent invoke() {
                return new PathComponent();
            }
        };
        $composer2.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation($composer2, "CC(ComposeNode):Composables.kt#9igjgp");
        if (!($composer2.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, androidx.compose.ui.graphics.vector.PathComponent] */
                @Override // kotlin.jvm.functions.Function0
                public final PathComponent invoke() {
                    return Function0.this.invoke();
                }
            });
        } else {
            $composer2.useNode();
        }
        Composer $this$Path_9cdaXJ4_u24lambda_u242 = Updater.m2583constructorimpl($composer2);
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, name2, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str) {
                invoke2(pathComponent, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, String it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setName(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, pathData, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list) {
                invoke2(pathComponent, list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, List<? extends PathNode> it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setPathData(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, PathFillType.m3218boximpl(pathFillType2), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType3) {
                m3585invokepweu1eQ(pathComponent, pathFillType3.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-pweu1eQ, reason: not valid java name */
            public final void m3585invokepweu1eQ(PathComponent set, int it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m3580setPathFillTypeoQ8Xj4U(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, fill2, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush) {
                invoke2(pathComponent, brush);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, Brush it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFill(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(fillAlpha2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFillAlpha(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, stroke2, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush) {
                invoke2(pathComponent, brush);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, Brush it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStroke(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeAlpha2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeAlpha(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeLineWidth2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineWidth(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, StrokeJoin.m3298boximpl(strokeLineJoin2), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                m3586invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-kLtJ_vA, reason: not valid java name */
            public final void m3586invokekLtJ_vA(PathComponent set, int it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m3582setStrokeLineJoinWw9F2mQ(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, StrokeCap.m3288boximpl(strokeLineCap2), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                m3584invokeCSYIeUk(pathComponent, strokeCap.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-CSYIeUk, reason: not valid java name */
            public final void m3584invokeCSYIeUk(PathComponent set, int it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m3581setStrokeLineCapBeK7IIE(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeLineMiter2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineMiter(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathStart2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathStart(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathEnd2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathEnd(it);
            }
        });
        Updater.m2590setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathOffset2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathOffset(it);
            }
        });
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final int i2 = pathFillType2;
        final String str = name2;
        final Brush brush = fill2;
        final float f = fillAlpha2;
        final Brush brush2 = stroke2;
        final float f2 = strokeAlpha2;
        final float f3 = strokeLineWidth2;
        final int i3 = strokeLineCap2;
        final int i4 = strokeLineJoin2;
        final float f4 = strokeLineMiter2;
        final float f5 = trimPathStart2;
        final float f6 = trimPathEnd2;
        final float f7 = trimPathOffset2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
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

            public final void invoke(Composer composer, int i5) {
                VectorComposeKt.m3583Path9cdaXJ4(pathData, i2, str, brush, f, brush2, f2, f3, i3, i4, f4, f5, f6, f7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }
}
