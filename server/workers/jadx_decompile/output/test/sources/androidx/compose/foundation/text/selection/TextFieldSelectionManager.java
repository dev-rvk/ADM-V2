package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020B2\b\b\u0002\u0010j\u001a\u00020!H\u0000¢\u0006\u0002\bkJ%\u0010l\u001a\u00020?2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\r\u0010s\u001a\u00020TH\u0000¢\u0006\u0002\btJ\r\u0010u\u001a\u00020BH\u0000¢\u0006\u0002\bvJ\u001f\u0010w\u001a\u00020B2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bxJ\r\u0010y\u001a\u00020BH\u0000¢\u0006\u0002\bzJ\r\u0010{\u001a\u00020BH\u0000¢\u0006\u0002\b|J\b\u0010}\u001a\u00020~H\u0002J$\u0010\u007f\u001a\u00020\f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J$\u0010\u0084\u0001\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020!H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0018\u0010\u0088\u0001\u001a\u00020T2\u0007\u0010\u0085\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0089\u0001J\u000f\u0010\u008a\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u008b\u0001J\u000f\u0010\u008c\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u008f\u0001J\u000f\u0010\u0090\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0091\u0001J\u0013\u0010\u0092\u0001\u001a\u00020B2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0002J\u000f\u0010\u0095\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0096\u0001J6\u0010\u0097\u0001\u001a\u00020B2\u0006\u0010Y\u001a\u00020?2\u0007\u0010\u0098\u0001\u001a\u00020\u00152\u0007\u0010\u0099\u0001\u001a\u00020\u00152\u0007\u0010\u0085\u0001\u001a\u00020!2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR8\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0019\u0010\u0017\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010@\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020B0AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR+\u0010Y\u001a\u00020?2\u0006\u0010\u000b\u001a\u00020?8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010\u0013\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010_\u001a\u00020`X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009c\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/TextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/TextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/TextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateSelection", "transformedStartOffset", "transformedEndOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    private ClipboardManager clipboardManager;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private TextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;
    private VisualTransformation visualTransformation;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.value = mutableStateOf$default;
        this.visualTransformation = VisualTransformation.INSTANCE.getNone();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.editable = mutableStateOf$default2;
        this.dragBeginPosition = Offset.INSTANCE.m2726getZeroF1C5BW0();
        this.dragTotalDistance = Offset.INSTANCE.m2726getZeroF1C5BW0();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = mutableStateOf$default4;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo805onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo807onStartk4lQ0M(long startPoint) {
                long j;
                TextLayoutResultProxy layoutResult;
                TextFieldState state;
                TextLayoutResultProxy layoutResult2;
                TextFieldValue newValue;
                TextLayoutResultProxy layoutResult3;
                if (TextFieldSelectionManager.this.getDraggingHandle() != null) {
                    return;
                }
                TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                TextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (!((state2 == null || (layoutResult3 = state2.getLayoutResult()) == null || !layoutResult3.m840isPositionOnTextk4lQ0M(startPoint)) ? false : true) && (state = TextFieldSelectionManager.this.getState()) != null && (layoutResult2 = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    int offset = textFieldSelectionManager.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.getLineEnd$default(layoutResult2, layoutResult2.getLineForVerticalPosition(Offset.m2711getYimpl(startPoint)), false, 2, null));
                    HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.mo3598performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m3607getTextHandleMove5zf0vsI());
                    }
                    newValue = textFieldSelectionManager.m943createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getText(), TextRangeKt.TextRange(offset, offset));
                    textFieldSelectionManager.enterSelectionMode$foundation_release();
                    textFieldSelectionManager.getOnValueChange$foundation_release().invoke(newValue);
                    return;
                }
                if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager.this.enterSelectionMode$foundation_release();
                TextFieldState state3 = TextFieldSelectionManager.this.getState();
                if (state3 != null && (layoutResult = state3.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    int offset2 = TextLayoutResultProxy.m837getOffsetForPosition3MmeM6k$default(layoutResult, startPoint, false, 2, null);
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), offset2, offset2, false, SelectionAdjustment.INSTANCE.getWord());
                    textFieldSelectionManager2.dragBeginOffsetInText = Integer.valueOf(offset2);
                }
                TextFieldSelectionManager.this.dragBeginPosition = startPoint;
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                j = TextFieldSelectionManager.this.dragBeginPosition;
                textFieldSelectionManager3.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(j));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m2726getZeroF1C5BW0();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo806onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                long j2;
                long j3;
                Integer num;
                long j4;
                int m839getOffsetForPosition3MmeM6k;
                if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m2715plusMKHz9U(j, delta);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    j2 = textFieldSelectionManager2.dragBeginPosition;
                    j3 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(Offset.m2715plusMKHz9U(j2, j3)));
                    num = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num != null) {
                        m839getOffsetForPosition3MmeM6k = num.intValue();
                    } else {
                        j4 = textFieldSelectionManager2.dragBeginPosition;
                        m839getOffsetForPosition3MmeM6k = layoutResult.m839getOffsetForPosition3MmeM6k(j4, false);
                    }
                    int startOffset = m839getOffsetForPosition3MmeM6k;
                    Offset m948getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m948getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m948getCurrentDragPosition_m7T9E);
                    int endOffset = layoutResult.m839getOffsetForPosition3MmeM6k(m948getCurrentDragPosition_m7T9E.getPackedValue(), false);
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), startOffset, endOffset, false, SelectionAdjustment.INSTANCE.getWord());
                }
                TextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 == null) {
                    return;
                }
                state2.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m945setCurrentDragPosition_kEHs6E(null);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null) {
                    state.setShowFloatingToolbar(true);
                }
                TextToolbar textToolbar = TextFieldSelectionManager.this.getTextToolbar();
                if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
                    TextFieldSelectionManager.this.showSelectionToolbar$foundation_release();
                }
                TextFieldSelectionManager.this.dragBeginOffsetInText = null;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo867onExtendk4lQ0M(long downPosition) {
                TextLayoutResultProxy layoutResult;
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    int startOffset = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m4726getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                    int clickOffset = TextLayoutResultProxy.m837getOffsetForPosition3MmeM6k$default(layoutResult, downPosition, false, 2, null);
                    textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), startOffset, clickOffset, false, SelectionAdjustment.INSTANCE.getNone());
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo868onExtendDragk4lQ0M(long dragPosition) {
                TextFieldState state;
                TextLayoutResultProxy layoutResult;
                if ((TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) || (state = TextFieldSelectionManager.this.getState()) == null || (layoutResult = state.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                int startOffset = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m4726getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                int dragOffset = layoutResult.m839getOffsetForPosition3MmeM6k(dragPosition, false);
                textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), startOffset, dragOffset, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo869onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                TextLayoutResultProxy layoutResult;
                long j;
                Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                if (focusRequester != null) {
                    focusRequester.requestFocus();
                }
                TextFieldSelectionManager.this.dragBeginPosition = downPosition;
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    textFieldSelectionManager.dragBeginOffsetInText = Integer.valueOf(TextLayoutResultProxy.m837getOffsetForPosition3MmeM6k$default(layoutResult, downPosition, false, 2, null));
                    j = textFieldSelectionManager.dragBeginPosition;
                    int clickOffset = TextLayoutResultProxy.m837getOffsetForPosition3MmeM6k$default(layoutResult, j, false, 2, null);
                    textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), clickOffset, clickOffset, false, adjustment);
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo866onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                TextFieldState state;
                TextLayoutResultProxy layoutResult;
                Integer num;
                Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                if ((TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) || (state = TextFieldSelectionManager.this.getState()) == null || (layoutResult = state.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                int dragOffset = layoutResult.m839getOffsetForPosition3MmeM6k(dragPosition, false);
                TextFieldValue value$foundation_release = textFieldSelectionManager.getValue$foundation_release();
                num = textFieldSelectionManager.dragBeginOffsetInText;
                Intrinsics.checkNotNull(num);
                textFieldSelectionManager.updateSelection(value$foundation_release, num.intValue(), dragOffset, false, adjustment);
                return true;
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* renamed from: getOffsetMapping$foundation_release, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        Intrinsics.checkNotNullParameter(offsetMapping, "<set-?>");
        this.offsetMapping = offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onValueChange = function1;
    }

    /* renamed from: getState$foundation_release, reason: from getter */
    public final TextFieldState getState() {
        return this.state;
    }

    public final void setState$foundation_release(TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        State $this$getValue$iv = this.value;
        return (TextFieldValue) $this$getValue$iv.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<set-?>");
        MutableState $this$setValue$iv = this.value;
        $this$setValue$iv.setValue(textFieldValue);
    }

    /* renamed from: getVisualTransformation$foundation_release, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        Intrinsics.checkNotNullParameter(visualTransformation, "<set-?>");
        this.visualTransformation = visualTransformation;
    }

    /* renamed from: getClipboardManager$foundation_release, reason: from getter */
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final boolean getEditable() {
        State $this$getValue$iv = this.editable;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        MutableState $this$setValue$iv = this.editable;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
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
    public final void m945setCurrentDragPosition_kEHs6E(Offset offset) {
        MutableState $this$setValue$iv = this.currentDragPosition;
        $this$setValue$iv.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m948getCurrentDragPosition_m7T9E() {
        State $this$getValue$iv = this.currentDragPosition;
        return (Offset) $this$getValue$iv.getValue();
    }

    /* renamed from: getTouchSelectionObserver$foundation_release, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    /* renamed from: getMouseSelectionObserver$foundation_release, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo805onDownk4lQ0M(long point) {
                TextFieldSelectionManager.this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                TextFieldSelectionManager.this.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(SelectionHandlesKt.m898getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m950getHandlePositiontuRUvjQ$foundation_release(isStartHandle))));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m945setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo807onStartk4lQ0M(long startPoint) {
                long j;
                TextFieldSelectionManager.this.dragBeginPosition = SelectionHandlesKt.m898getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m950getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = TextFieldSelectionManager.this.dragBeginPosition;
                textFieldSelectionManager.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(j));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m2726getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null) {
                    return;
                }
                state.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo806onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                TextLayoutResult layoutResult2;
                long j2;
                long j3;
                int startOffset;
                int endOffset;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m2715plusMKHz9U(j, delta);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (layoutResult2 = layoutResult.getValue()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    boolean z = isStartHandle;
                    j2 = textFieldSelectionManager2.dragBeginPosition;
                    j3 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(Offset.m2715plusMKHz9U(j2, j3)));
                    if (z) {
                        Offset m948getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m948getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m948getCurrentDragPosition_m7T9E);
                        startOffset = layoutResult2.m4698getOffsetForPositionk4lQ0M(m948getCurrentDragPosition_m7T9E.getPackedValue());
                    } else {
                        startOffset = textFieldSelectionManager2.getOffsetMapping().originalToTransformed(TextRange.m4726getStartimpl(textFieldSelectionManager2.getValue$foundation_release().getSelection()));
                    }
                    if (z) {
                        endOffset = textFieldSelectionManager2.getOffsetMapping().originalToTransformed(TextRange.m4721getEndimpl(textFieldSelectionManager2.getValue$foundation_release().getSelection()));
                    } else {
                        Offset m948getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m948getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m948getCurrentDragPosition_m7T9E2);
                        endOffset = layoutResult2.m4698getOffsetForPositionk4lQ0M(m948getCurrentDragPosition_m7T9E2.getPackedValue());
                    }
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), startOffset, endOffset, z, SelectionAdjustment.INSTANCE.getCharacter());
                }
                TextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 == null) {
                    return;
                }
                state2.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m945setCurrentDragPosition_kEHs6E(null);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null) {
                    state.setShowFloatingToolbar(true);
                }
                TextToolbar textToolbar = TextFieldSelectionManager.this.getTextToolbar();
                if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
                    TextFieldSelectionManager.this.showSelectionToolbar$foundation_release();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo805onDownk4lQ0M(long point) {
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager.this.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(SelectionHandlesKt.m898getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m950getHandlePositiontuRUvjQ$foundation_release(true))));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m945setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo807onStartk4lQ0M(long startPoint) {
                long j;
                TextFieldSelectionManager.this.dragBeginPosition = SelectionHandlesKt.m898getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m950getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = TextFieldSelectionManager.this.dragBeginPosition;
                textFieldSelectionManager.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(j));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m2726getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo806onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                TextLayoutResult layoutResult2;
                long j2;
                long j3;
                TextFieldValue m943createTextFieldValueFDrldGo;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m2715plusMKHz9U(j, delta);
                TextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (layoutResult2 = layoutResult.getValue()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    j2 = textFieldSelectionManager2.dragBeginPosition;
                    j3 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m945setCurrentDragPosition_kEHs6E(Offset.m2699boximpl(Offset.m2715plusMKHz9U(j2, j3)));
                    OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                    Offset m948getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m948getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m948getCurrentDragPosition_m7T9E);
                    int offset = offsetMapping.transformedToOriginal(layoutResult2.m4698getOffsetForPositionk4lQ0M(m948getCurrentDragPosition_m7T9E.getPackedValue()));
                    long newSelection = TextRangeKt.TextRange(offset, offset);
                    if (TextRange.m4719equalsimpl0(newSelection, textFieldSelectionManager2.getValue$foundation_release().getSelection())) {
                        return;
                    }
                    HapticFeedback hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.mo3598performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m3607getTextHandleMove5zf0vsI());
                    }
                    Function1<TextFieldValue, Unit> onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                    m943createTextFieldValueFDrldGo = textFieldSelectionManager2.m943createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getText(), newSelection);
                    onValueChange$foundation_release.invoke(m943createTextFieldValueFDrldGo);
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m945setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
    }

    public final void enterSelectionMode$foundation_release() {
        FocusRequester focusRequester;
        TextFieldState textFieldState = this.state;
        boolean z = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z = true;
        }
        if (z && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowFloatingToolbar(true);
        }
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(false);
        }
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m944deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m947deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m947deselect_kEHs6E$foundation_release(Offset position) {
        HandleState selectionMode;
        int newCursorOffset;
        if (!TextRange.m4720getCollapsedimpl(getValue$foundation_release().getSelection())) {
            TextFieldState textFieldState = this.state;
            TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
            if (position != null && layoutResult != null) {
                newCursorOffset = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m837getOffsetForPosition3MmeM6k$default(layoutResult, position.getPackedValue(), false, 2, null));
            } else {
                newCursorOffset = TextRange.m4723getMaximpl(getValue$foundation_release().getSelection());
            }
            TextFieldValue newValue = TextFieldValue.m4939copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(newCursorOffset), (TextRange) null, 5, (Object) null);
            this.onValueChange.invoke(newValue);
        }
        if (position != null) {
            if (getValue$foundation_release().getText().length() > 0) {
                selectionMode = HandleState.Cursor;
                setHandleState(selectionMode);
                hideSelectionToolbar$foundation_release();
            }
        }
        selectionMode = HandleState.None;
        setHandleState(selectionMode);
        hideSelectionToolbar$foundation_release();
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    public final void copy$foundation_release(boolean cancelSelection) {
        if (TextRange.m4720getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (cancelSelection) {
            int newCursorOffset = TextRange.m4723getMaximpl(getValue$foundation_release().getSelection());
            TextFieldValue newValue = m943createTextFieldValueFDrldGo(getValue$foundation_release().getText(), TextRangeKt.TextRange(newCursorOffset, newCursorOffset));
            this.onValueChange.invoke(newValue);
            setHandleState(HandleState.None);
        }
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString newText = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int newCursorOffset = TextRange.m4724getMinimpl(getValue$foundation_release().getSelection()) + text.length();
        TextFieldValue newValue = m943createTextFieldValueFDrldGo(newText, TextRangeKt.TextRange(newCursorOffset, newCursorOffset));
        this.onValueChange.invoke(newValue);
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void cut$foundation_release() {
        if (TextRange.m4720getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString newText = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int newCursorOffset = TextRange.m4724getMinimpl(getValue$foundation_release().getSelection());
        TextFieldValue newValue = m943createTextFieldValueFDrldGo(newText, TextRangeKt.TextRange(newCursorOffset, newCursorOffset));
        this.onValueChange.invoke(newValue);
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue newValue = m943createTextFieldValueFDrldGo(getValue$foundation_release().getText(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(newValue);
        this.oldValue = TextFieldValue.m4939copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, newValue.getSelection(), (TextRange) null, 5, (Object) null);
        TextFieldState textFieldState = this.state;
        if (textFieldState == null) {
            return;
        }
        textFieldState.setShowFloatingToolbar(true);
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m950getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        long selection = getValue$foundation_release().getSelection();
        int offset = isStartHandle ? TextRange.m4726getStartimpl(selection) : TextRange.m4721getEndimpl(selection);
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult.getValue(), this.offsetMapping.originalToTransformed(offset), isStartHandle, TextRange.m4725getReversedimpl(getValue$foundation_release().getSelection()));
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m949getCursorPositiontuRUvjQ$foundation_release(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        int offset = this.offsetMapping.originalToTransformed(TextRange.m4726getStartimpl(getValue$foundation_release().getSelection()));
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult layoutResult2 = layoutResult.getValue();
        Rect cursorRect = layoutResult2.getCursorRect(RangesKt.coerceIn(offset, 0, layoutResult2.getLayoutInput().getText().length()));
        float x = cursorRect.getLeft() + (density.mo329toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2);
        return OffsetKt.Offset(x, cursorRect.getBottom());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showSelectionToolbar$foundation_release() {
        /*
            r9 = this;
            androidx.compose.ui.text.input.VisualTransformation r0 = r9.visualTransformation
            boolean r0 = r0 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r1 = r1.getSelection()
            boolean r1 = androidx.compose.ui.text.TextRange.m4720getCollapsedimpl(r1)
            r2 = 0
            if (r1 != 0) goto L1e
            if (r0 != 0) goto L1e
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            r1.<init>()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r5 = r1
            goto L1f
        L1e:
            r5 = r2
        L1f:
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r3 = r1.getSelection()
            boolean r1 = androidx.compose.ui.text.TextRange.m4720getCollapsedimpl(r3)
            if (r1 != 0) goto L3f
            boolean r1 = r9.getEditable()
            if (r1 == 0) goto L3f
            if (r0 != 0) goto L3f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            r1.<init>()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r7 = r1
            goto L40
        L3f:
            r7 = r2
        L40:
            boolean r1 = r9.getEditable()
            if (r1 == 0) goto L5f
            androidx.compose.ui.platform.ClipboardManager r1 = r9.clipboardManager
            r3 = 0
            if (r1 == 0) goto L54
            boolean r1 = r1.hasText()
            r4 = 1
            if (r1 != r4) goto L54
            r3 = r4
        L54:
            if (r3 == 0) goto L5f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            r1.<init>()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r6 = r1
            goto L60
        L5f:
            r6 = r2
        L60:
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r3 = r1.getSelection()
            int r1 = androidx.compose.ui.text.TextRange.m4722getLengthimpl(r3)
            androidx.compose.ui.text.input.TextFieldValue r3 = r9.getValue$foundation_release()
            java.lang.String r3 = r3.getText()
            int r3 = r3.length()
            if (r1 == r3) goto L85
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            r1.<init>()
            r2 = r1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r8 = r2
            goto L86
        L85:
            r8 = r2
        L86:
            androidx.compose.ui.platform.TextToolbar r3 = r9.textToolbar
            if (r3 == 0) goto L96
            androidx.compose.ui.geometry.Rect r4 = r9.getContentRect()
            r3.showMenu(r4, r5, r6, r7, r8)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m946contextMenuOpenAdjustmentk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        TextFieldState textFieldState = this.state;
        if (textFieldState != null && (layoutResult = textFieldState.getLayoutResult()) != null) {
            int offset = TextLayoutResultProxy.m837getOffsetForPosition3MmeM6k$default(layoutResult, position, false, 2, null);
            if (!TextRange.m4717containsimpl(getValue$foundation_release().getSelection(), offset)) {
                updateSelection(getValue$foundation_release(), offset, offset, false, SelectionAdjustment.INSTANCE.getWord());
            }
        }
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    private final Rect getContentRect() {
        long startOffset;
        long endOffset;
        float startTop;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        TextFieldState it = this.state;
        if (it != null) {
            if (!(!it.getIsLayoutResultStale())) {
                it = null;
            }
            if (it != null) {
                int transformedStart = this.offsetMapping.originalToTransformed(TextRange.m4726getStartimpl(getValue$foundation_release().getSelection()));
                int transformedEnd = this.offsetMapping.originalToTransformed(TextRange.m4721getEndimpl(getValue$foundation_release().getSelection()));
                TextFieldState textFieldState = this.state;
                if (textFieldState != null && (layoutCoordinates4 = textFieldState.getLayoutCoordinates()) != null) {
                    startOffset = layoutCoordinates4.mo4195localToRootMKHz9U(m950getHandlePositiontuRUvjQ$foundation_release(true));
                } else {
                    startOffset = Offset.INSTANCE.m2726getZeroF1C5BW0();
                }
                TextFieldState textFieldState2 = this.state;
                if (textFieldState2 != null && (layoutCoordinates3 = textFieldState2.getLayoutCoordinates()) != null) {
                    endOffset = layoutCoordinates3.mo4195localToRootMKHz9U(m950getHandlePositiontuRUvjQ$foundation_release(false));
                } else {
                    endOffset = Offset.INSTANCE.m2726getZeroF1C5BW0();
                }
                TextFieldState textFieldState3 = this.state;
                float endTop = 0.0f;
                if (textFieldState3 != null && (layoutCoordinates2 = textFieldState3.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult = it.getLayoutResult();
                    startTop = Offset.m2711getYimpl(layoutCoordinates2.mo4195localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(transformedStart)) == null) ? 0.0f : cursorRect2.getTop())));
                } else {
                    startTop = 0.0f;
                }
                TextFieldState textFieldState4 = this.state;
                if (textFieldState4 != null && (layoutCoordinates = textFieldState4.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = it.getLayoutResult();
                    endTop = Offset.m2711getYimpl(layoutCoordinates.mo4195localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(transformedEnd)) == null) ? 0.0f : cursorRect.getTop())));
                }
                float left = Math.min(Offset.m2710getXimpl(startOffset), Offset.m2710getXimpl(endOffset));
                float right = Math.max(Offset.m2710getXimpl(startOffset), Offset.m2710getXimpl(endOffset));
                float top = Math.min(startTop, endTop);
                float bottom = Math.max(Offset.m2711getYimpl(startOffset), Offset.m2711getYimpl(endOffset)) + (Dp.m5218constructorimpl(25) * it.getTextDelegate().getDensity().getDensity());
                return new Rect(left, top, right, bottom);
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelection(TextFieldValue value, int transformedStartOffset, int transformedEndOffset, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResultProxy layoutResult;
        long transformedSelection = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m4726getStartimpl(value.getSelection())), this.offsetMapping.originalToTransformed(TextRange.m4721getEndimpl(value.getSelection())));
        TextFieldState textFieldState = this.state;
        long newTransformedSelection = TextFieldSelectionDelegateKt.m940getTextFieldSelectionbb3KNj8((textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) ? null : layoutResult.getValue(), transformedStartOffset, transformedEndOffset, TextRange.m4720getCollapsedimpl(transformedSelection) ? null : TextRange.m4714boximpl(transformedSelection), isStartHandle, adjustment);
        long originalSelection = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(TextRange.m4726getStartimpl(newTransformedSelection)), this.offsetMapping.transformedToOriginal(TextRange.m4721getEndimpl(newTransformedSelection)));
        if (TextRange.m4719equalsimpl0(originalSelection, value.getSelection())) {
            return;
        }
        HapticFeedback hapticFeedback = this.hapticFeedBack;
        if (hapticFeedback != null) {
            hapticFeedback.mo3598performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m3607getTextHandleMove5zf0vsI());
        }
        TextFieldValue newValue = m943createTextFieldValueFDrldGo(value.getText(), originalSelection);
        this.onValueChange.invoke(newValue);
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        TextFieldState textFieldState3 = this.state;
        if (textFieldState3 == null) {
            return;
        }
        textFieldState3.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
    }

    private final void setHandleState(HandleState handleState) {
        TextFieldState it = this.state;
        if (it != null) {
            it.setHandleState(handleState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m943createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
