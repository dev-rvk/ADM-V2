package androidx.compose.material.internal;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposedDropdownMenuPopup.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt$SimpleStack$1 implements MeasurePolicy {
    public static final ExposedDropdownMenuPopupKt$SimpleStack$1 INSTANCE = new ExposedDropdownMenuPopupKt$SimpleStack$1();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo15measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        switch (measurables.size()) {
            case 0:
                return MeasureScope.layout$default(Layout, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1$measure$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    }
                }, 4, null);
            case 1:
                final Placeable p = measurables.get(0).mo4186measureBRTryo0(constraints);
                return MeasureScope.layout$default(Layout, p.getWidth(), p.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1$measure$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            default:
                List target$iv = new ArrayList(measurables.size());
                int size = measurables.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    Object item$iv$iv = measurables.get(index$iv$iv);
                    Measurable it = (Measurable) item$iv$iv;
                    target$iv.add(it.mo4186measureBRTryo0(constraints));
                }
                final List placeables = target$iv;
                int width = 0;
                int height = 0;
                int i = 0;
                int lastIndex = CollectionsKt.getLastIndex(placeables);
                if (0 <= lastIndex) {
                    while (true) {
                        Placeable p2 = (Placeable) placeables.get(i);
                        width = Math.max(width, p2.getWidth());
                        height = Math.max(height, p2.getHeight());
                        if (i != lastIndex) {
                            i++;
                        }
                    }
                }
                return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        int i2 = 0;
                        int lastIndex2 = CollectionsKt.getLastIndex(placeables);
                        if (0 > lastIndex2) {
                            return;
                        }
                        while (true) {
                            Placeable p3 = placeables.get(i2);
                            Placeable.PlacementScope.placeRelative$default(layout, p3, 0, 0, 0.0f, 4, null);
                            if (i2 == lastIndex2) {
                                return;
                            } else {
                                i2++;
                            }
                        }
                    }
                }, 4, null);
        }
    }
}
