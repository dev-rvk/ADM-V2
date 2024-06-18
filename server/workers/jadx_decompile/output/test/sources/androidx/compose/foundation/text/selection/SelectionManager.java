package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionManager.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u00020\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010\"J'\u0010i\u001a\u0004\u0018\u00010\u00162\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\r\u0010n\u001a\u00020LH\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0000¢\u0006\u0002\btJ\b\u0010u\u001a\u00020vH\u0002J\u000f\u0010w\u001a\u0004\u0018\u00010xH\u0000¢\u0006\u0002\byJ\u000e\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020?J\r\u0010}\u001a\u00020LH\u0000¢\u0006\u0002\b~J\u0006\u0010\u007f\u001a\u00020LJ\u000f\u0010\u0080\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0081\u0001JA\u0010\u0082\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0085\u0001\u0012\u0004\u0012\u00020\u00070\u0084\u00010\u0083\u00012\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0003\b\u0088\u0001J\u000f\u0010\u0089\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u008a\u0001J2\u0010\u008b\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\t\u0010\u0090\u0001\u001a\u00020LH\u0002JE\u0010\u0091\u0001\u001a\u00020?2\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J<\u0010\u0091\u0001\u001a\u00020?2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00162\b\u0010Q\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0003\b\u0096\u0001J\t\u0010\u0097\u0001\u001a\u00020LH\u0002J0\u0010\u0098\u0001\u001a\u00020L*\u00030\u0099\u00012\u0013\u0010\u009a\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020L0KH\u0082@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J\u001d\u0010\u009c\u0001\u001a\u00020G*\u00020G2\u000e\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020L0\u009e\u0001H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R8\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR4\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R4\u0010$\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R/\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0015\u001a\u0004\u0018\u00010(8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R8\u0010/\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001d\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010@\u001a\u00020?2\u0006\u0010\u0015\u001a\u00020?8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010IR(\u0010J\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020L0KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0019\u0010Q\u001a\u0004\u0018\u00010\u0016X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R(\u0010R\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010BR8\u0010Y\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u001d\u001a\u0004\bZ\u0010\u0019\"\u0004\b[\u0010\u001bR\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010B\"\u0004\be\u0010D\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009f\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_selection", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/selection/Selection;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onSelectionChange", "Lkotlin/Function1;", "", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "previousPosition", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "shouldShowMagnifier", "getShouldShowMagnifier", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchMode", "getTouchMode", "setTouchMode", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-Q7Q5hAU", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)Landroidx/compose/ui/geometry/Offset;", "copy", "copy$foundation_release", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "Lkotlin/Pair;", "", "", "selectableId", "previousSelection", "selectAll$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "startSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateHandleOffsets", "updateSelection", "previousHandlePosition", "updateSelection-3R_-tFg$foundation_release", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-RHHTvR4$foundation_release", "updateSelectionToolbarPosition", "detectNonConsumingTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionManager {
    private final MutableState<Selection> _selection;
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;

    /* renamed from: dragBeginPosition$delegate, reason: from kotlin metadata */
    private final MutableState dragBeginPosition;

    /* renamed from: dragTotalDistance$delegate, reason: from kotlin metadata */
    private final MutableState dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: endHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState endHandlePosition;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;

    /* renamed from: hasFocus$delegate, reason: from kotlin metadata */
    private final MutableState hasFocus;
    private Function1<? super Selection, Unit> onSelectionChange;
    private Offset previousPosition;
    private final SelectionRegistrarImpl selectionRegistrar;

    /* renamed from: startHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState startHandlePosition;
    private TextToolbar textToolbar;
    private boolean touchMode;

    public SelectionManager(SelectionRegistrarImpl selectionRegistrar) {
        MutableState<Selection> mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        Intrinsics.checkNotNullParameter(selectionRegistrar, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrar;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._selection = mutableStateOf$default;
        this.touchMode = true;
        this.onSelectionChange = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Selection selection) {
                invoke2(selection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Selection it) {
            }
        };
        this.focusRequester = new FocusRequester();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.hasFocus = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2699boximpl(Offset.INSTANCE.m2726getZeroF1C5BW0()), null, 2, null);
        this.dragBeginPosition = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2699boximpl(Offset.INSTANCE.m2726getZeroF1C5BW0()), null, 2, null);
        this.dragTotalDistance = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.startHandlePosition = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = mutableStateOf$default8;
        this.selectionRegistrar.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long selectableId) {
                Selection.AnchorInfo end;
                Selection.AnchorInfo start;
                Selection selection = SelectionManager.this.getSelection();
                if (!((selection == null || (start = selection.getStart()) == null || selectableId != start.getSelectableId()) ? false : true)) {
                    Selection selection2 = SelectionManager.this.getSelection();
                    if (!((selection2 == null || (end = selection2.getEnd()) == null || selectableId != end.getSelectableId()) ? false : true)) {
                        return;
                    }
                }
                SelectionManager.this.updateHandleOffsets();
                SelectionManager.this.updateSelectionToolbarPosition();
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateStartCallback$foundation_release(new Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates, Offset offset, SelectionAdjustment selectionAdjustment) {
                m926invoked4ec7I(layoutCoordinates, offset.getPackedValue(), selectionAdjustment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final void m926invoked4ec7I(LayoutCoordinates layoutCoordinates, long position, SelectionAdjustment selectionMode) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionMode, "selectionMode");
                Offset positionInContainer = SelectionManager.this.m911convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, position);
                if (positionInContainer != null) {
                    SelectionManager.this.m917startSelection9KIMszo(positionInContainer.getPackedValue(), false, selectionMode);
                    SelectionManager.this.getFocusRequester().requestFocus();
                    SelectionManager.this.hideSelectionToolbar$foundation_release();
                }
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateSelectAll$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long selectableId) {
                Pair<Selection, Map<Long, Selection>> selectAll$foundation_release = SelectionManager.this.selectAll$foundation_release(selectableId, SelectionManager.this.getSelection());
                Selection newSelection = selectAll$foundation_release.component1();
                Map newSubselection = selectAll$foundation_release.component2();
                if (!Intrinsics.areEqual(newSelection, SelectionManager.this.getSelection())) {
                    SelectionManager.this.selectionRegistrar.setSubselections(newSubselection);
                    SelectionManager.this.getOnSelectionChange().invoke(newSelection);
                }
                SelectionManager.this.getFocusRequester().requestFocus();
                SelectionManager.this.hideSelectionToolbar$foundation_release();
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateCallback$foundation_release(new Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.4
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Boolean invoke(LayoutCoordinates layoutCoordinates, Offset offset, Offset offset2, Boolean bool, SelectionAdjustment selectionAdjustment) {
                return m927invoke5iVPX68(layoutCoordinates, offset.getPackedValue(), offset2.getPackedValue(), bool.booleanValue(), selectionAdjustment);
            }

            /* renamed from: invoke-5iVPX68, reason: not valid java name */
            public final Boolean m927invoke5iVPX68(LayoutCoordinates layoutCoordinates, long newPosition, long previousPosition, boolean isStartHandle, SelectionAdjustment selectionMode) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionMode, "selectionMode");
                Offset newPositionInContainer = SelectionManager.this.m911convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, newPosition);
                Offset previousPositionInContainer = SelectionManager.this.m911convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, previousPosition);
                return Boolean.valueOf(SelectionManager.this.m925updateSelectionRHHTvR4$foundation_release(newPositionInContainer, previousPositionInContainer, isStartHandle, selectionMode));
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m912setCurrentDragPosition_kEHs6E(null);
            }
        });
        this.selectionRegistrar.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long selectableKey) {
                if (SelectionManager.this.selectionRegistrar.getSubselections().containsKey(Long.valueOf(selectableKey))) {
                    SelectionManager.this.onRelease();
                    SelectionManager.this.setSelection(null);
                }
            }
        });
        this.selectionRegistrar.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long selectableKey) {
                Selection.AnchorInfo end;
                Selection.AnchorInfo start;
                Selection selection = SelectionManager.this.getSelection();
                if (!((selection == null || (start = selection.getStart()) == null || selectableKey != start.getSelectableId()) ? false : true)) {
                    Selection selection2 = SelectionManager.this.getSelection();
                    if (!((selection2 == null || (end = selection2.getEnd()) == null || selectableKey != end.getSelectableId()) ? false : true)) {
                        return;
                    }
                }
                SelectionManager.this.m916setStartHandlePosition_kEHs6E(null);
                SelectionManager.this.m915setEndHandlePosition_kEHs6E(null);
            }
        });
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    public final void setSelection(Selection value) {
        this._selection.setValue(value);
        if (value != null) {
            updateHandleOffsets();
        }
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    public final void setTouchMode(boolean z) {
        this.touchMode = z;
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final void setOnSelectionChange(Function1<? super Selection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSelectionChange = function1;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final void setClipboardManager(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.focusRequester = focusRequester;
    }

    public final boolean getHasFocus() {
        State $this$getValue$iv = this.hasFocus;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        MutableState $this$setValue$iv = this.hasFocus;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final Modifier getModifier() {
        return KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(Modifier.INSTANCE, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SelectionManager.this.onRelease();
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SelectionManager.this.setContainerLayoutCoordinates(it);
            }
        }), this.focusRequester), new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                invoke2(focusState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FocusState focusState) {
                Intrinsics.checkNotNullParameter(focusState, "focusState");
                if (!focusState.isFocused() && SelectionManager.this.getHasFocus()) {
                    SelectionManager.this.onRelease();
                }
                SelectionManager.this.setHasFocus(focusState.isFocused());
            }
        }), false, null, 3, null), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m928invokeZmokQxo(keyEvent.m3924unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m928invokeZmokQxo(android.view.KeyEvent it) {
                boolean z;
                Intrinsics.checkNotNullParameter(it, "it");
                if (SelectionManager_androidKt.m932isCopyKeyEventZmokQxo(it)) {
                    SelectionManager.this.copy$foundation_release();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }).then(getShouldShowMagnifier() ? SelectionManager_androidKt.selectionMagnifier(Modifier.INSTANCE, this) : Modifier.INSTANCE);
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates value) {
        this.containerLayoutCoordinates = value;
        if (getHasFocus() && getSelection() != null) {
            Offset positionInWindow = value != null ? Offset.m2699boximpl(LayoutCoordinatesKt.positionInWindow(value)) : null;
            if (!Intrinsics.areEqual(this.previousPosition, positionInWindow)) {
                this.previousPosition = positionInWindow;
                updateHandleOffsets();
                updateSelectionToolbarPosition();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public final void m913setDragBeginPositionk4lQ0M(long j) {
        MutableState $this$setValue$iv = this.dragBeginPosition;
        $this$setValue$iv.setValue(Offset.m2699boximpl(j));
    }

    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m920getDragBeginPositionF1C5BW0$foundation_release() {
        State $this$getValue$iv = this.dragBeginPosition;
        return ((Offset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public final void m914setDragTotalDistancek4lQ0M(long j) {
        MutableState $this$setValue$iv = this.dragTotalDistance;
        $this$setValue$iv.setValue(Offset.m2699boximpl(j));
    }

    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m921getDragTotalDistanceF1C5BW0$foundation_release() {
        State $this$getValue$iv = this.dragTotalDistance;
        return ((Offset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m916setStartHandlePosition_kEHs6E(Offset offset) {
        MutableState $this$setValue$iv = this.startHandlePosition;
        $this$setValue$iv.setValue(offset);
    }

    /* renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m923getStartHandlePosition_m7T9E() {
        State $this$getValue$iv = this.startHandlePosition;
        return (Offset) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m915setEndHandlePosition_kEHs6E(Offset offset) {
        MutableState $this$setValue$iv = this.endHandlePosition;
        $this$setValue$iv.setValue(offset);
    }

    /* renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m922getEndHandlePosition_m7T9E() {
        State $this$getValue$iv = this.endHandlePosition;
        return (Offset) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        MutableState $this$setValue$iv = this.draggingHandle;
        $this$setValue$iv.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        State $this$getValue$iv = this.draggingHandle;
        return (Handle) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m912setCurrentDragPosition_kEHs6E(Offset offset) {
        MutableState $this$setValue$iv = this.currentDragPosition;
        $this$setValue$iv.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m919getCurrentDragPosition_m7T9E() {
        State $this$getValue$iv = this.currentDragPosition;
        return (Offset) $this$getValue$iv.getValue();
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null;
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchor.getSelectableId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateHandleOffsets() {
        /*
            r20 = this;
            r0 = r20
            androidx.compose.foundation.text.selection.Selection r1 = r20.getSelection()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.containerLayoutCoordinates
            if (r1 == 0) goto L16
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r1.getStart()
            if (r4 == 0) goto L16
            r5 = 0
            androidx.compose.foundation.text.selection.Selectable r4 = r0.getAnchorSelectable$foundation_release(r4)
            goto L17
        L16:
            r4 = 0
        L17:
            if (r1 == 0) goto L25
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r5 = r1.getEnd()
            if (r5 == 0) goto L25
            r6 = 0
            androidx.compose.foundation.text.selection.Selectable r5 = r0.getAnchorSelectable$foundation_release(r5)
            goto L26
        L25:
            r5 = 0
        L26:
            if (r4 == 0) goto L2d
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.getLayoutCoordinates()
            goto L2e
        L2d:
            r6 = 0
        L2e:
            if (r5 == 0) goto L35
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.getLayoutCoordinates()
            goto L36
        L35:
            r7 = 0
        L36:
            if (r1 == 0) goto Lc1
            if (r2 == 0) goto Lbe
            boolean r8 = r2.isAttached()
            if (r8 == 0) goto Lbb
            if (r6 == 0) goto Lb8
            if (r7 != 0) goto L49
            r18 = r1
            goto Lc3
        L49:
            r8 = 1
            long r9 = r4.mo879getHandlePositiondBAh8RU(r1, r8)
            long r9 = r2.mo4194localPositionOfR5De75A(r6, r9)
            r11 = 0
            long r12 = r5.mo879getHandlePositiondBAh8RU(r1, r11)
            long r12 = r2.mo4194localPositionOfR5De75A(r7, r12)
            androidx.compose.ui.geometry.Rect r14 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r2)
            androidx.compose.ui.geometry.Offset r15 = androidx.compose.ui.geometry.Offset.m2699boximpl(r9)
            long r16 = r15.getPackedValue()
            r18 = 0
            boolean r19 = androidx.compose.foundation.text.selection.SelectionManagerKt.m931containsInclusiveUv8p0NA(r14, r9)
            if (r19 != 0) goto L84
            androidx.compose.foundation.text.Handle r8 = r20.getDraggingHandle()
            androidx.compose.foundation.text.Handle r11 = androidx.compose.foundation.text.Handle.SelectionStart
            if (r8 != r11) goto L82
            goto L84
        L82:
            r8 = 0
            goto L85
        L84:
            r8 = 1
        L85:
            if (r8 == 0) goto L89
            goto L8a
        L89:
            r15 = 0
        L8a:
            r0.m916setStartHandlePosition_kEHs6E(r15)
            androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m2699boximpl(r12)
            long r15 = r8.getPackedValue()
            r11 = 0
            boolean r17 = androidx.compose.foundation.text.selection.SelectionManagerKt.m931containsInclusiveUv8p0NA(r14, r12)
            if (r17 != 0) goto Laa
            androidx.compose.foundation.text.Handle r3 = r20.getDraggingHandle()
            r18 = r1
            androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionEnd
            if (r3 != r1) goto La7
            goto Lac
        La7:
            r19 = 0
            goto Lae
        Laa:
            r18 = r1
        Lac:
            r19 = 1
        Lae:
            if (r19 == 0) goto Lb3
            r3 = r8
            goto Lb4
        Lb3:
            r3 = 0
        Lb4:
            r0.m915setEndHandlePosition_kEHs6E(r3)
            return
        Lb8:
            r18 = r1
            goto Lc3
        Lbb:
            r18 = r1
            goto Lc3
        Lbe:
            r18 = r1
            goto Lc3
        Lc1:
            r18 = r1
        Lc3:
            r1 = 0
            r0.m916setStartHandlePosition_kEHs6E(r1)
            r0.m915setEndHandlePosition_kEHs6E(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.updateHandleOffsets():void");
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates coordinates = this.containerLayoutCoordinates;
        if (!(coordinates != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!coordinates.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return coordinates;
    }

    public final Pair<Selection, Map<Long, Selection>> selectAll$foundation_release(long selectableId, Selection previousSelection) {
        HapticFeedback hapticFeedback;
        Object initial$iv;
        int $i$f$fastFold;
        Map subselections = new LinkedHashMap();
        List $this$fastFold$iv = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Object initial$iv2 = null;
        int $i$f$fastFold2 = 0;
        Selection selection = null;
        int index$iv$iv = 0;
        int size = $this$fastFold$iv.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastFold$iv.get(index$iv$iv);
            Selectable selectable = (Selectable) item$iv$iv;
            Selection mergedSelection = selection;
            Selection selection2 = selectable.getSelectableId() == selectableId ? selectable.getSelectAllSelection() : null;
            List $this$fastFold$iv2 = $this$fastFold$iv;
            if (selection2 != null) {
                initial$iv = initial$iv2;
                $i$f$fastFold = $i$f$fastFold2;
                subselections.put(Long.valueOf(selectable.getSelectableId()), selection2);
            } else {
                initial$iv = initial$iv2;
                $i$f$fastFold = $i$f$fastFold2;
            }
            selection = SelectionManagerKt.merge(mergedSelection, selection2);
            index$iv$iv++;
            $this$fastFold$iv = $this$fastFold$iv2;
            $i$f$fastFold2 = $i$f$fastFold;
            initial$iv2 = initial$iv;
        }
        Selection newSelection = selection;
        if (!Intrinsics.areEqual(newSelection, previousSelection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo3598performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m3607getTextHandleMove5zf0vsI());
        }
        return new Pair<>(newSelection, subselections);
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString annotatedString;
        List selectables = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        AnnotatedString annotatedString2 = null;
        Selection it = getSelection();
        if (it != null) {
            int size = selectables.size();
            for (int i = 0; i < size; i++) {
                Selectable selectable = selectables.get(i);
                if (selectable.getSelectableId() == it.getStart().getSelectableId() || selectable.getSelectableId() == it.getEnd().getSelectableId() || annotatedString2 != null) {
                    AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, it);
                    if (annotatedString2 == null || (annotatedString = annotatedString2.plus(currentSelectedText)) == null) {
                        annotatedString = currentSelectedText;
                    }
                    annotatedString2 = annotatedString;
                    if (selectable.getSelectableId() == it.getEnd().getSelectableId()) {
                        if (!it.getHandlesCrossed()) {
                            break;
                        }
                    }
                    if (selectable.getSelectableId() == it.getStart().getSelectableId() && it.getHandlesCrossed()) {
                        break;
                    }
                }
            }
        }
        return annotatedString2;
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager;
        AnnotatedString selectedText = getSelectedText$foundation_release();
        if (selectedText == null || (clipboardManager = this.clipboardManager) == null) {
            return;
        }
        clipboardManager.setText(selectedText);
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (getHasFocus() && getSelection() != null && (textToolbar = this.textToolbar) != null) {
            TextToolbar.showMenu$default(textToolbar, getContentRect(), new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$showSelectionToolbar$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SelectionManager.this.copy$foundation_release();
                    SelectionManager.this.onRelease();
                }
            }, null, null, null, 28, null);
        }
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
                return;
            }
            textToolbar.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        if (getHasFocus()) {
            TextToolbar textToolbar = this.textToolbar;
            if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    private final Rect getContentRect() {
        LayoutCoordinates startLayoutCoordinates;
        LayoutCoordinates endLayoutCoordinates;
        Selection selection = getSelection();
        if (selection == null) {
            return Rect.INSTANCE.getZero();
        }
        Selectable startSelectable = getAnchorSelectable$foundation_release(selection.getStart());
        Selectable endSelectable = getAnchorSelectable$foundation_release(selection.getEnd());
        if (startSelectable != null && (startLayoutCoordinates = startSelectable.getLayoutCoordinates()) != null) {
            if (endSelectable != null && (endLayoutCoordinates = endSelectable.getLayoutCoordinates()) != null) {
                LayoutCoordinates localLayoutCoordinates = this.containerLayoutCoordinates;
                if (localLayoutCoordinates != null && localLayoutCoordinates.isAttached()) {
                    long startOffset = localLayoutCoordinates.mo4194localPositionOfR5De75A(startLayoutCoordinates, startSelectable.mo879getHandlePositiondBAh8RU(selection, true));
                    long endOffset = localLayoutCoordinates.mo4194localPositionOfR5De75A(endLayoutCoordinates, endSelectable.mo879getHandlePositiondBAh8RU(selection, false));
                    long startOffset2 = localLayoutCoordinates.mo4195localToRootMKHz9U(startOffset);
                    long endOffset2 = localLayoutCoordinates.mo4195localToRootMKHz9U(endOffset);
                    float left = Math.min(Offset.m2710getXimpl(startOffset2), Offset.m2710getXimpl(endOffset2));
                    float right = Math.max(Offset.m2710getXimpl(startOffset2), Offset.m2710getXimpl(endOffset2));
                    long startTop = localLayoutCoordinates.mo4194localPositionOfR5De75A(startLayoutCoordinates, OffsetKt.Offset(0.0f, startSelectable.getBoundingBox(selection.getStart().getOffset()).getTop()));
                    long endTop = localLayoutCoordinates.mo4194localPositionOfR5De75A(endLayoutCoordinates, OffsetKt.Offset(0.0f, endSelectable.getBoundingBox(selection.getEnd().getOffset()).getTop()));
                    float top = Math.min(Offset.m2711getYimpl(localLayoutCoordinates.mo4195localToRootMKHz9U(startTop)), Offset.m2711getYimpl(localLayoutCoordinates.mo4195localToRootMKHz9U(endTop)));
                    float bottom = Math.max(Offset.m2711getYimpl(startOffset2), Offset.m2711getYimpl(endOffset2)) + ((float) (SelectionHandlesKt.getHandleHeight() * 4.0d));
                    return new Rect(left, top, right, bottom);
                }
                return Rect.INSTANCE.getZero();
            }
            return Rect.INSTANCE.getZero();
        }
        return Rect.INSTANCE.getZero();
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(MapsKt.emptyMap());
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo3598performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m3607getTextHandleMove5zf0vsI());
            }
        }
    }

    public final TextDragObserver handleDragObserver(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo805onDownk4lQ0M(long point) {
                LayoutCoordinates beginLayoutCoordinates;
                Selection selection = SelectionManager.this.getSelection();
                if (selection == null) {
                    return;
                }
                Selection.AnchorInfo anchor = isStartHandle ? selection.getStart() : selection.getEnd();
                Selectable selectable = SelectionManager.this.getAnchorSelectable$foundation_release(anchor);
                if (selectable == null || (beginLayoutCoordinates = selectable.getLayoutCoordinates()) == null) {
                    return;
                }
                long beginCoordinates = SelectionHandlesKt.m898getAdjustedCoordinatesk4lQ0M(selectable.mo879getHandlePositiondBAh8RU(selection, isStartHandle));
                SelectionManager.this.m912setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(SelectionManager.this.requireContainerCoordinates$foundation_release().mo4194localPositionOfR5De75A(beginLayoutCoordinates, beginCoordinates)));
                SelectionManager.this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m912setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo807onStartk4lQ0M(long startPoint) {
                LayoutCoordinates layoutCoordinates;
                long mo879getHandlePositiondBAh8RU;
                SelectionManager.this.hideSelectionToolbar$foundation_release();
                Selection selection = SelectionManager.this.getSelection();
                Intrinsics.checkNotNull(selection);
                Selectable startSelectable = SelectionManager.this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getStart().getSelectableId()));
                Selectable endSelectable = SelectionManager.this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getEnd().getSelectableId()));
                if (isStartHandle) {
                    layoutCoordinates = startSelectable != null ? startSelectable.getLayoutCoordinates() : null;
                    Intrinsics.checkNotNull(layoutCoordinates);
                } else {
                    layoutCoordinates = endSelectable != null ? endSelectable.getLayoutCoordinates() : null;
                    Intrinsics.checkNotNull(layoutCoordinates);
                }
                LayoutCoordinates beginLayoutCoordinates = layoutCoordinates;
                if (isStartHandle) {
                    Intrinsics.checkNotNull(startSelectable);
                    mo879getHandlePositiondBAh8RU = startSelectable.mo879getHandlePositiondBAh8RU(selection, true);
                } else {
                    Intrinsics.checkNotNull(endSelectable);
                    mo879getHandlePositiondBAh8RU = endSelectable.mo879getHandlePositiondBAh8RU(selection, false);
                }
                long beginCoordinates = SelectionHandlesKt.m898getAdjustedCoordinatesk4lQ0M(mo879getHandlePositiondBAh8RU);
                SelectionManager.this.m913setDragBeginPositionk4lQ0M(SelectionManager.this.requireContainerCoordinates$foundation_release().mo4194localPositionOfR5De75A(beginLayoutCoordinates, beginCoordinates));
                SelectionManager.this.m914setDragTotalDistancek4lQ0M(Offset.INSTANCE.m2726getZeroF1C5BW0());
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo806onDragk4lQ0M(long delta) {
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.m914setDragTotalDistancek4lQ0M(Offset.m2715plusMKHz9U(selectionManager.m921getDragTotalDistanceF1C5BW0$foundation_release(), delta));
                long endPosition = Offset.m2715plusMKHz9U(SelectionManager.this.m920getDragBeginPositionF1C5BW0$foundation_release(), SelectionManager.this.m921getDragTotalDistanceF1C5BW0$foundation_release());
                boolean consumed = SelectionManager.this.m925updateSelectionRHHTvR4$foundation_release(Offset.m2699boximpl(endPosition), Offset.m2699boximpl(SelectionManager.this.m920getDragBeginPositionF1C5BW0$foundation_release()), isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate());
                if (consumed) {
                    SelectionManager.this.m913setDragBeginPositionk4lQ0M(endPosition);
                    SelectionManager.this.m914setDragTotalDistancek4lQ0M(Offset.INSTANCE.m2726getZeroF1C5BW0());
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m912setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m912setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope $this$detectNonConsumingTap, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectNonConsumingTap, new SelectionManager$detectNonConsumingTap$2(function1, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    private final Modifier onClearSelectionRequested(Modifier $this$onClearSelectionRequested, Function0<Unit> function0) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput($this$onClearSelectionRequested, Unit.INSTANCE, new SelectionManager$onClearSelectionRequested$1(this, function0, null)) : $this$onClearSelectionRequested;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-Q7Q5hAU, reason: not valid java name */
    public final Offset m911convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long offset) {
        LayoutCoordinates coordinates = this.containerLayoutCoordinates;
        if (coordinates == null || !coordinates.isAttached()) {
            return null;
        }
        return Offset.m2699boximpl(requireContainerCoordinates$foundation_release().mo4194localPositionOfR5De75A(layoutCoordinates, offset));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo, reason: not valid java name */
    public final void m917startSelection9KIMszo(long position, boolean isStartHandle, SelectionAdjustment adjustment) {
        m924updateSelection3R_tFg$foundation_release(position, position, null, isStartHandle, adjustment);
    }

    /* renamed from: updateSelection-RHHTvR4$foundation_release, reason: not valid java name */
    public final boolean m925updateSelectionRHHTvR4$foundation_release(Offset newPosition, Offset previousPosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        Selection selection;
        long otherSelectableId;
        Offset m911convertToContainerCoordinatesQ7Q5hAU;
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        if (newPosition != null && (selection = getSelection()) != null) {
            if (isStartHandle) {
                otherSelectableId = selection.getEnd().getSelectableId();
            } else {
                otherSelectableId = selection.getStart().getSelectableId();
            }
            Selectable otherSelectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(otherSelectableId));
            if (otherSelectable == null) {
                m911convertToContainerCoordinatesQ7Q5hAU = null;
            } else {
                LayoutCoordinates layoutCoordinates = otherSelectable.getLayoutCoordinates();
                Intrinsics.checkNotNull(layoutCoordinates);
                m911convertToContainerCoordinatesQ7Q5hAU = m911convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m898getAdjustedCoordinatesk4lQ0M(otherSelectable.mo879getHandlePositiondBAh8RU(selection, !isStartHandle)));
            }
            if (m911convertToContainerCoordinatesQ7Q5hAU != null) {
                long otherHandlePosition = m911convertToContainerCoordinatesQ7Q5hAU.getPackedValue();
                long startHandlePosition = isStartHandle ? newPosition.getPackedValue() : otherHandlePosition;
                long endHandlePosition = isStartHandle ? otherHandlePosition : newPosition.getPackedValue();
                return m924updateSelection3R_tFg$foundation_release(startHandlePosition, endHandlePosition, previousPosition, isStartHandle, adjustment);
            }
        }
        return false;
    }

    /* renamed from: updateSelection-3R_-tFg$foundation_release, reason: not valid java name */
    public final boolean m924updateSelection3R_tFg$foundation_release(long startHandlePosition, long endHandlePosition, Offset previousHandlePosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        m912setCurrentDragPosition_kEHs6E(isStartHandle ? Offset.m2699boximpl(startHandlePosition) : Offset.m2699boximpl(endHandlePosition));
        Map newSubselections = new LinkedHashMap();
        List $this$fastFold$iv = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        List $this$fastForEach$iv$iv = $this$fastFold$iv;
        int size = $this$fastForEach$iv$iv.size();
        boolean moveConsumed = false;
        Selection selection = null;
        int index$iv$iv = 0;
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Selectable selectable = (Selectable) item$iv$iv;
            Selection mergedSelection = selection;
            Selection previousSubselection = this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId()));
            int index$iv$iv2 = index$iv$iv;
            int i = size;
            List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
            Pair<Selection, Boolean> mo881updateSelectionqCDeeow = selectable.mo881updateSelectionqCDeeow(startHandlePosition, endHandlePosition, previousHandlePosition, isStartHandle, requireContainerCoordinates$foundation_release(), adjustment, previousSubselection);
            Selection selection2 = mo881updateSelectionqCDeeow.component1();
            boolean consumed = mo881updateSelectionqCDeeow.component2().booleanValue();
            moveConsumed = moveConsumed || consumed;
            if (selection2 != null) {
                newSubselections.put(Long.valueOf(selectable.getSelectableId()), selection2);
            }
            selection = SelectionManagerKt.merge(mergedSelection, selection2);
            index$iv$iv = index$iv$iv2 + 1;
            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
            size = i;
        }
        Selection newSelection = selection;
        if (!Intrinsics.areEqual(newSelection, getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo3598performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m3607getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(newSubselections);
            this.onSelectionChange.invoke(newSelection);
        }
        return moveConsumed;
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m918contextMenuOpenAdjustmentk4lQ0M(long position) {
        Selection selection = getSelection();
        boolean isEmptySelection = selection != null ? TextRange.m4720getCollapsedimpl(selection.m888toTextRanged9O1mEE()) : true;
        if (isEmptySelection) {
            m917startSelection9KIMszo(position, true, SelectionAdjustment.INSTANCE.getWord());
        }
    }
}
