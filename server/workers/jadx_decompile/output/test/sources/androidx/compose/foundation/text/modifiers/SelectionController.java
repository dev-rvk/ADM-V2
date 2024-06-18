package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.BasicText_androidKt;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SelectionController.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eR\u0019\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/runtime/RememberObserver;", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "backgroundSelectionColor", "Landroidx/compose/ui/graphics/Color;", "params", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrar;JLandroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "draw", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "updateGlobalPosition", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateTextLayout", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionController implements RememberObserver {
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    private StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;

    public /* synthetic */ SelectionController(SelectionRegistrar selectionRegistrar, long j, StaticTextSelectionParams staticTextSelectionParams, DefaultConstructorMarker defaultConstructorMarker) {
        this(selectionRegistrar, j, staticTextSelectionParams);
    }

    private SelectionController(SelectionRegistrar selectionRegistrar, long backgroundSelectionColor, StaticTextSelectionParams params) {
        Modifier makeSelectionModifier;
        Intrinsics.checkNotNullParameter(selectionRegistrar, "selectionRegistrar");
        Intrinsics.checkNotNullParameter(params, "params");
        this.selectionRegistrar = selectionRegistrar;
        this.backgroundSelectionColor = backgroundSelectionColor;
        this.params = params;
        this.selectableId = this.selectionRegistrar.nextSelectableId();
        makeSelectionModifier = SelectionControllerKt.makeSelectionModifier(this.selectionRegistrar, this.selectableId, new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$modifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                StaticTextSelectionParams staticTextSelectionParams;
                staticTextSelectionParams = SelectionController.this.params;
                return staticTextSelectionParams.getLayoutCoordinates();
            }
        }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$modifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextLayoutResult invoke() {
                StaticTextSelectionParams staticTextSelectionParams;
                staticTextSelectionParams = SelectionController.this.params;
                return staticTextSelectionParams.getTextLayoutResult();
            }
        }, TouchMode_androidKt.isInTouchMode());
        this.modifier = BasicText_androidKt.textPointerHoverIcon(makeSelectionModifier, this.selectionRegistrar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SelectionController(androidx.compose.foundation.text.selection.SelectionRegistrar r7, long r8, androidx.compose.foundation.text.modifiers.StaticTextSelectionParams r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r11 = r11 & 4
            if (r11 == 0) goto Lc
            androidx.compose.foundation.text.modifiers.StaticTextSelectionParams$Companion r10 = androidx.compose.foundation.text.modifiers.StaticTextSelectionParams.INSTANCE
            androidx.compose.foundation.text.modifiers.StaticTextSelectionParams r10 = r10.getEmpty()
            r4 = r10
            goto Ld
        Lc:
            r4 = r10
        Ld:
            r5 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.SelectionController.<init>(androidx.compose.foundation.text.selection.SelectionRegistrar, long, androidx.compose.foundation.text.modifiers.StaticTextSelectionParams, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                StaticTextSelectionParams staticTextSelectionParams;
                staticTextSelectionParams = SelectionController.this.params;
                return staticTextSelectionParams.getLayoutCoordinates();
            }
        }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextLayoutResult invoke() {
                StaticTextSelectionParams staticTextSelectionParams;
                staticTextSelectionParams = SelectionController.this.params;
                return staticTextSelectionParams.getTextLayoutResult();
            }
        }));
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        Selectable localSelectable = this.selectable;
        if (localSelectable != null) {
            this.selectionRegistrar.unsubscribe(localSelectable);
            this.selectable = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        Selectable localSelectable = this.selectable;
        if (localSelectable != null) {
            this.selectionRegistrar.unsubscribe(localSelectable);
            this.selectable = null;
        }
    }

    public final void updateTextLayout(TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        this.params = StaticTextSelectionParams.copy$default(this.params, null, textLayoutResult, 1, null);
    }

    public final void updateGlobalPosition(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.params = StaticTextSelectionParams.copy$default(this.params, coordinates, null, 2, null);
    }

    public final void draw(DrawScope drawScope) {
        int offset;
        int offset2;
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        Selection selection = this.selectionRegistrar.getSubselections().get(Long.valueOf(this.selectableId));
        if (selection == null) {
            return;
        }
        if (!selection.getHandlesCrossed()) {
            offset = selection.getStart().getOffset();
        } else {
            offset = selection.getEnd().getOffset();
        }
        int start = offset;
        if (!selection.getHandlesCrossed()) {
            offset2 = selection.getEnd().getOffset();
        } else {
            offset2 = selection.getStart().getOffset();
        }
        int end = offset2;
        if (start == end) {
            return;
        }
        Selectable selectable = this.selectable;
        int lastOffset = selectable != null ? selectable.getLastVisibleOffset() : 0;
        int clippedStart = RangesKt.coerceAtMost(start, lastOffset);
        int clippedEnd = RangesKt.coerceAtMost(end, lastOffset);
        Path selectionPath = this.params.getPathForRange(clippedStart, clippedEnd);
        if (selectionPath == null) {
            return;
        }
        if (!this.params.getShouldClip()) {
            DrawScope.m3483drawPathLG529CI$default(drawScope, selectionPath, this.backgroundSelectionColor, 0.0f, null, null, 0, 60, null);
            return;
        }
        float right$iv = Size.m2779getWidthimpl(drawScope.mo3492getSizeNHjbRc());
        float bottom$iv = Size.m2776getHeightimpl(drawScope.mo3492getSizeNHjbRc());
        int clipOp$iv = ClipOp.INSTANCE.m2938getIntersectrtfAjoo();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = drawScope.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
        $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo3420clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
        DrawScope.m3483drawPathLG529CI$default(drawScope, selectionPath, this.backgroundSelectionColor, 0.0f, null, null, 0, 60, null);
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
    }
}
