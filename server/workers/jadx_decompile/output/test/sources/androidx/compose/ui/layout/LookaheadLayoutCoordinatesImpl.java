package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: LookaheadLayoutCoordinates.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001aH\u0096\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\nH\u0016J%\u0010'\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001d\u0010/\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010.J%\u00101\u001a\u0002022\u0006\u0010%\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010.R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "()J", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public long mo4193getSizeYbymL2g() {
        LookaheadDelegate it = this.lookaheadDelegate;
        return IntSizeKt.IntSize(it.getWidth(), it.getHeight());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates.toString());
        }
        NodeCoordinator it = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy();
        if (it == null || (lookaheadDelegate = it.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            throw new IllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates.toString());
        }
        NodeCoordinator wrappedBy = getCoordinator().getWrappedBy();
        if (wrappedBy == null || (lookaheadDelegate = wrappedBy.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    private final long m4208getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate it = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m2714minusMKHz9U(mo4194localPositionOfR5De75A(it.getCoordinates(), Offset.INSTANCE.m2726getZeroF1C5BW0()), getCoordinator().mo4194localPositionOfR5De75A(it.getCoordinator(), Offset.INSTANCE.m2726getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo4198windowToLocalMKHz9U(long relativeToWindow) {
        return Offset.m2715plusMKHz9U(getCoordinator().mo4198windowToLocalMKHz9U(relativeToWindow), m4208getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo4196localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().mo4196localToWindowMKHz9U(Offset.m2715plusMKHz9U(relativeToLocal, m4208getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo4195localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().mo4195localToRootMKHz9U(Offset.m2715plusMKHz9U(relativeToLocal, m4208getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo4194localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (sourceCoordinates instanceof LookaheadLayoutCoordinatesImpl) {
            LookaheadDelegate source = ((LookaheadLayoutCoordinatesImpl) sourceCoordinates).lookaheadDelegate;
            source.getCoordinator().onCoordinatesUsed$ui_release();
            NodeCoordinator commonAncestor = getCoordinator().findCommonAncestor$ui_release(source.getCoordinator());
            LookaheadDelegate ancestor = commonAncestor.getLookaheadDelegate();
            if (ancestor != null) {
                long arg0$iv = source.m4352positionInBjo55l4$ui_release(ancestor);
                long $this$round_u2dk_u2d4lQ0M$iv = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2710getXimpl(relativeToSource)), MathKt.roundToInt(Offset.m2711getYimpl(relativeToSource)));
                long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv) + IntOffset.m5336getXimpl($this$round_u2dk_u2d4lQ0M$iv), IntOffset.m5337getYimpl(arg0$iv) + IntOffset.m5337getYimpl($this$round_u2dk_u2d4lQ0M$iv));
                long other$iv = this.lookaheadDelegate.m4352positionInBjo55l4$ui_release(ancestor);
                long arg0$iv3 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv2) - IntOffset.m5336getXimpl(other$iv), IntOffset.m5337getYimpl(arg0$iv2) - IntOffset.m5337getYimpl(other$iv));
                long $this$toOffset_u2d_u2dgyyYBs$iv = OffsetKt.Offset(IntOffset.m5336getXimpl(arg0$iv3), IntOffset.m5337getYimpl(arg0$iv3));
                return $this$toOffset_u2d_u2dgyyYBs$iv;
            }
            LookaheadDelegate sourceRoot = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(source);
            long arg0$iv4 = source.m4352positionInBjo55l4$ui_release(sourceRoot);
            long other$iv2 = sourceRoot.getPosition();
            long arg0$iv5 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv4) + IntOffset.m5336getXimpl(other$iv2), IntOffset.m5337getYimpl(arg0$iv4) + IntOffset.m5337getYimpl(other$iv2));
            long $this$round_u2dk_u2d4lQ0M$iv2 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2710getXimpl(relativeToSource)), MathKt.roundToInt(Offset.m2711getYimpl(relativeToSource)));
            long arg0$iv6 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv5) + IntOffset.m5336getXimpl($this$round_u2dk_u2d4lQ0M$iv2), IntOffset.m5337getYimpl(arg0$iv5) + IntOffset.m5337getYimpl($this$round_u2dk_u2d4lQ0M$iv2));
            LookaheadDelegate $this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246 = this.lookaheadDelegate;
            long arg0$iv7 = $this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246.m4352positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246));
            long other$iv3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localPositionOf_R5De75A_u24lambda_u247_u24lambda_u246).getPosition();
            long other$iv4 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv7) + IntOffset.m5336getXimpl(other$iv3), IntOffset.m5337getYimpl(arg0$iv7) + IntOffset.m5337getYimpl(other$iv3));
            long other$iv5 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv6) - IntOffset.m5336getXimpl(other$iv4), IntOffset.m5337getYimpl(arg0$iv6) - IntOffset.m5337getYimpl(other$iv4));
            NodeCoordinator wrappedBy = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy();
            Intrinsics.checkNotNull(wrappedBy);
            NodeCoordinator wrappedBy2 = sourceRoot.getCoordinator().getWrappedBy();
            Intrinsics.checkNotNull(wrappedBy2);
            long $this$toOffset_u2d_u2dgyyYBs$iv2 = OffsetKt.Offset(IntOffset.m5336getXimpl(other$iv5), IntOffset.m5337getYimpl(other$iv5));
            return wrappedBy.mo4194localPositionOfR5De75A(wrappedBy2, $this$toOffset_u2d_u2dgyyYBs$iv2);
        }
        LookaheadDelegate rootDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m2715plusMKHz9U(mo4194localPositionOfR5De75A(rootDelegate.getLookaheadLayoutCoordinates(), relativeToSource), rootDelegate.getCoordinator().getCoordinates().mo4194localPositionOfR5De75A(sourceCoordinates, Offset.INSTANCE.m2726getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo4197transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        getCoordinator().mo4197transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return this.lookaheadDelegate.get(alignmentLine);
    }
}
