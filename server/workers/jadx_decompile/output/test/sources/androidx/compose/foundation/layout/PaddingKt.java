package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001aA\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a!\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a-\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001aA\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"PaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "all", "Landroidx/compose/ui/unit/Dp;", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "horizontal", "vertical", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "start", "top", "end", "bottom", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "Landroidx/compose/ui/Modifier;", "left", "right", "absolutePadding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "calculateEndPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateStartPadding", "padding", "paddingValues", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "padding-qDBjuR0", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PaddingKt {
    /* renamed from: padding-qDBjuR0$default */
    public static /* synthetic */ Modifier m488paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp = i & 2;
        if ($i$f$getDp != 0) {
            f2 = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp2 = i & 4;
        if ($i$f$getDp2 != 0) {
            f3 = Dp.m5218constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5218constructorimpl(0);
        }
        return m487paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: padding-qDBjuR0 */
    public static final Modifier m487paddingqDBjuR0(Modifier padding, final float start, final float top, final float end, final float bottom) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingElement(start, top, end, bottom, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.setName("padding");
                $receiver.getProperties().set("start", Dp.m5216boximpl(start));
                $receiver.getProperties().set("top", Dp.m5216boximpl(top));
                $receiver.getProperties().set("end", Dp.m5216boximpl(end));
                $receiver.getProperties().set("bottom", Dp.m5216boximpl(bottom));
            }
        }, null));
    }

    /* renamed from: padding-VpY3zN4$default */
    public static /* synthetic */ Modifier m486paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5218constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5218constructorimpl(0);
        }
        return m485paddingVpY3zN4(modifier, f, f2);
    }

    /* renamed from: padding-VpY3zN4 */
    public static final Modifier m485paddingVpY3zN4(Modifier padding, final float horizontal, final float vertical) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingElement(horizontal, vertical, horizontal, vertical, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.setName("padding");
                $receiver.getProperties().set("horizontal", Dp.m5216boximpl(horizontal));
                $receiver.getProperties().set("vertical", Dp.m5216boximpl(vertical));
            }
        }, null));
    }

    /* renamed from: padding-3ABfNKs */
    public static final Modifier m484padding3ABfNKs(Modifier padding, final float all) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingElement(all, all, all, all, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.setName("padding");
                $receiver.setValue(Dp.m5216boximpl(all));
            }
        }, null));
    }

    public static final Modifier padding(Modifier $this$padding, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter($this$padding, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return $this$padding.then(new PaddingValuesElement(paddingValues, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.setName("padding");
                $receiver.getProperties().set("paddingValues", PaddingValues.this);
            }
        }));
    }

    /* renamed from: absolutePadding-qDBjuR0$default */
    public static /* synthetic */ Modifier m483absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp = i & 2;
        if ($i$f$getDp != 0) {
            f2 = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp2 = i & 4;
        if ($i$f$getDp2 != 0) {
            f3 = Dp.m5218constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5218constructorimpl(0);
        }
        return m482absolutePaddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: absolutePadding-qDBjuR0 */
    public static final Modifier m482absolutePaddingqDBjuR0(Modifier absolutePadding, final float left, final float top, final float right, final float bottom) {
        Intrinsics.checkNotNullParameter(absolutePadding, "$this$absolutePadding");
        return absolutePadding.then(new PaddingElement(left, top, right, bottom, false, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$absolutePadding$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.setName("absolutePadding");
                $receiver.getProperties().set("left", Dp.m5216boximpl(left));
                $receiver.getProperties().set("top", Dp.m5216boximpl(top));
                $receiver.getProperties().set("right", Dp.m5216boximpl(right));
                $receiver.getProperties().set("bottom", Dp.m5216boximpl(bottom));
            }
        }, null));
    }

    public static final float calculateStartPadding(PaddingValues $this$calculateStartPadding, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter($this$calculateStartPadding, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return $this$calculateStartPadding.mo435calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return $this$calculateStartPadding.mo436calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateEndPadding(PaddingValues $this$calculateEndPadding, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter($this$calculateEndPadding, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return $this$calculateEndPadding.mo436calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return $this$calculateEndPadding.mo435calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    /* renamed from: PaddingValues-0680j_4 */
    public static final PaddingValues m477PaddingValues0680j_4(float all) {
        return new PaddingValues(all, all, all, all, null);
    }

    /* renamed from: PaddingValues-YgX7TsA$default */
    public static /* synthetic */ PaddingValues m479PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5218constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5218constructorimpl(0);
        }
        return m478PaddingValuesYgX7TsA(f, f2);
    }

    /* renamed from: PaddingValues-YgX7TsA */
    public static final PaddingValues m478PaddingValuesYgX7TsA(float horizontal, float vertical) {
        return new PaddingValues(horizontal, vertical, horizontal, vertical, null);
    }

    /* renamed from: PaddingValues-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m481PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp = i & 2;
        if ($i$f$getDp != 0) {
            f2 = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp2 = i & 4;
        if ($i$f$getDp2 != 0) {
            f3 = Dp.m5218constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5218constructorimpl(0);
        }
        return m480PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: PaddingValues-a9UjIt4 */
    public static final PaddingValues m480PaddingValuesa9UjIt4(float start, float top, float end, float bottom) {
        return new PaddingValues(start, top, end, bottom, null);
    }
}
