package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutMeasureScope.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JH\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\u0096\u0001J+\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J\u001a\u0010/\u001a\u00020\u0019*\u000200H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\u001a\u0010/\u001a\u00020\u0019*\u000203H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u000200*\u000203H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u001c\u00106\u001a\u000200*\u00020\tH\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J\u001c\u00106\u001a\u000200*\u00020\u0019H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010;J\u0019\u0010<\u001a\u00020=*\u00020>H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\u001a\u0010A\u001a\u00020\t*\u000200H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010:J\u001a\u0010A\u001a\u00020\t*\u000203H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u00108J\r\u0010D\u001a\u00020E*\u00020FH\u0097\u0001J\u0019\u0010G\u001a\u00020>*\u00020=H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010@J\u0019\u0010I\u001a\u000203*\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010KJ\u001c\u0010I\u001a\u000203*\u00020\tH\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010KJ\u001c\u0010I\u001a\u000203*\u00020\u0019H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010MR\u0014\u0010\b\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8WX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0018j\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "placeablesCache", "Ljava/util/HashMap;", "", "", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/collections/HashMap;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "measure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final LazyLayoutItemProvider itemProvider;
    private final HashMap<Integer, List<Placeable>> placeablesCache;
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
        Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
        return this.subcomposeMeasureScope.layout(width, height, alignmentLines, placementBlock);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public int mo322roundToPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo322roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo323roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo323roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo328toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo328toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo329toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo329toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory itemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        Intrinsics.checkNotNullParameter(itemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "subcomposeMeasureScope");
        this.itemContentFactory = itemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.itemProvider = this.itemContentFactory.getItemProvider().invoke();
        this.placeablesCache = new HashMap<>();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    /* renamed from: measure-0kLqBqw */
    public List<Placeable> mo642measure0kLqBqw(int index, long constraints) {
        List cachedPlaceable = this.placeablesCache.get(Integer.valueOf(index));
        if (cachedPlaceable != null) {
            return cachedPlaceable;
        }
        Object key = this.itemProvider.getKey(index);
        Object contentType = this.itemProvider.getContentType(index);
        Function2 itemContent = this.itemContentFactory.getContent(index, key, contentType);
        List measurables = this.subcomposeMeasureScope.subcompose(key, itemContent);
        int size = measurables.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            int i2 = i;
            arrayList.add(measurables.get(i2).mo4186measureBRTryo0(constraints));
        }
        ArrayList it = arrayList;
        this.placeablesCache.put(Integer.valueOf(index), it);
        return it;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public float mo324toDpGaN1DYA(long $this$toDp_u2dGaN1DYA) {
        SubcomposeMeasureScope $this$toDp_GaN1DYA_u24lambda_u242 = this.subcomposeMeasureScope;
        return $this$toDp_GaN1DYA_u24lambda_u242.mo324toDpGaN1DYA($this$toDp_u2dGaN1DYA);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo326toDpu2uoSUM(int $this$toDp_u2du2uoSUM) {
        SubcomposeMeasureScope $this$toDp_u2uoSUM_u24lambda_u243 = this.subcomposeMeasureScope;
        return $this$toDp_u2uoSUM_u24lambda_u243.mo326toDpu2uoSUM($this$toDp_u2du2uoSUM);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo325toDpu2uoSUM(float $this$toDp_u2du2uoSUM) {
        SubcomposeMeasureScope $this$toDp_u2uoSUM_u24lambda_u244 = this.subcomposeMeasureScope;
        return $this$toDp_u2uoSUM_u24lambda_u244.mo325toDpu2uoSUM($this$toDp_u2du2uoSUM);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo332toSpkPz2Gy4(float $this$toSp_u2dkPz2Gy4) {
        SubcomposeMeasureScope $this$toSp_kPz2Gy4_u24lambda_u245 = this.subcomposeMeasureScope;
        return $this$toSp_kPz2Gy4_u24lambda_u245.mo332toSpkPz2Gy4($this$toSp_u2dkPz2Gy4);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo333toSpkPz2Gy4(int $this$toSp_u2dkPz2Gy4) {
        SubcomposeMeasureScope $this$toSp_kPz2Gy4_u24lambda_u246 = this.subcomposeMeasureScope;
        return $this$toSp_kPz2Gy4_u24lambda_u246.mo333toSpkPz2Gy4($this$toSp_u2dkPz2Gy4);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public long mo331toSp0xMU5do(float $this$toSp_u2d0xMU5do) {
        SubcomposeMeasureScope $this$toSp_0xMU5do_u24lambda_u247 = this.subcomposeMeasureScope;
        return $this$toSp_0xMU5do_u24lambda_u247.mo331toSp0xMU5do($this$toSp_u2d0xMU5do);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo330toSizeXkaWNTQ(long $this$toSize_u2dXkaWNTQ) {
        SubcomposeMeasureScope $this$toSize_XkaWNTQ_u24lambda_u248 = this.subcomposeMeasureScope;
        return $this$toSize_XkaWNTQ_u24lambda_u248.mo330toSizeXkaWNTQ($this$toSize_u2dXkaWNTQ);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo327toDpSizekrfVVM(long $this$toDpSize_u2dk_u2drfVVM) {
        SubcomposeMeasureScope $this$toDpSize_k_rfVVM_u24lambda_u249 = this.subcomposeMeasureScope;
        return $this$toDpSize_k_rfVVM_u24lambda_u249.mo327toDpSizekrfVVM($this$toDpSize_u2dk_u2drfVVM);
    }
}
