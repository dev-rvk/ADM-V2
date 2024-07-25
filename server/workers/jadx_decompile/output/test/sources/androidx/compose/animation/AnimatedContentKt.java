package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014ø\u0001\u0000\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0086\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0087\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimatedContentKt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <S> void AnimatedContent(final S r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r23, androidx.compose.ui.Alignment r24, java.lang.String r25, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r26, final kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m14invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                }

                /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m14invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean clip, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        Intrinsics.checkNotNullParameter(sizeAnimationSpec, "sizeAnimationSpec");
        return new SizeTransformImpl(clip, sizeAnimationSpec);
    }

    public static final ContentTransform togetherWith(EnterTransition $this$togetherWith, ExitTransition exit) {
        Intrinsics.checkNotNullParameter($this$togetherWith, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform($this$togetherWith, exit, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition $this$with, ExitTransition exit) {
        Intrinsics.checkNotNullParameter($this$with, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform($this$with, exit, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0472 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f1 A[LOOP:2: B:134:0x02ef->B:135:0x02f1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x037a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <S> void AnimatedContent(final androidx.compose.animation.core.Transition<S> r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r31, androidx.compose.ui.Alignment r32, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r33, final kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 1361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
