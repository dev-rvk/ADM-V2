package androidx.compose.ui.text.input;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordingInputConnection.android.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0012\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\"\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\fH\u0016J\u0018\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0016J\u0018\u00105\u001a\u00020\u00072\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0007H\u0002J\u0017\u00108\u001a\u00020\u00072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c0:H\u0082\bJ\b\u0010;\u001a\u00020\u0007H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\fH\u0016J\u001a\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010)\u001a\u00020\fH\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u0004\u0018\u0001002\u0006\u0010)\u001a\u00020\fH\u0016J\u0018\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u0002002\u0006\u0010F\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\fH\u0016J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\fH\u0016J\u001c\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010J2\b\u0010Q\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\fH\u0016J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\fH\u0002J\u0018\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\fH\u0016J\u001a\u0010^\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\fH\u0016J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\fH\u0016J\u0016\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006d"}, d2 = {"Landroidx/compose/ui/text/input/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/ui/text/input/InputEventCallback2;", "autoCorrect", "", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputEventCallback2;Z)V", "getAutoCorrect", "()Z", "batchDepth", "", "currentExtractedTextRequestToken", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "getEventCallback", "()Landroidx/compose/ui/text/input/InputEventCallback2;", "extractedTextMonitorMode", "isActive", "value", "mTextFieldValue", "getMTextFieldValue$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setMTextFieldValue$ui_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "addEditCommandWithBatch", "", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "text", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "ensureActive", "block", "Lkotlin/Function0;", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performPrivateCommand", "action", "data", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RecordingInputConnection implements InputConnection {
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final List<EditCommand> editCommands;
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive;
    private TextFieldValue mTextFieldValue;

    public RecordingInputConnection(TextFieldValue initState, InputEventCallback2 eventCallback, boolean autoCorrect) {
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.eventCallback = eventCallback;
        this.autoCorrect = autoCorrect;
        this.mTextFieldValue = initState;
        this.editCommands = new ArrayList();
        this.isActive = true;
    }

    public final InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getMTextFieldValue$ui_release, reason: from getter */
    public final TextFieldValue getMTextFieldValue() {
        return this.mTextFieldValue;
    }

    public final void setMTextFieldValue$ui_release(TextFieldValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mTextFieldValue = value;
    }

    private final boolean ensureActive(Function0<Unit> block) {
        boolean applying = this.isActive;
        if (applying) {
            block.invoke();
        }
        return applying;
    }

    public final void updateInputState(TextFieldValue state, InputMethodManager inputMethodManager) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
        if (this.isActive) {
            setMTextFieldValue$ui_release(state);
            if (this.extractedTextMonitorMode) {
                inputMethodManager.updateExtractedText(this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(state));
            }
            TextRange composition = state.getComposition();
            int compositionStart = composition != null ? TextRange.m4724getMinimpl(composition.getPackedValue()) : -1;
            TextRange composition2 = state.getComposition();
            int compositionEnd = composition2 != null ? TextRange.m4723getMaximpl(composition2.getPackedValue()) : -1;
            inputMethodManager.updateSelection(TextRange.m4724getMinimpl(state.getSelection()), TextRange.m4723getMaximpl(state.getSelection()), compositionStart, compositionEnd);
        }
    }

    private final void addEditCommandWithBatch(EditCommand editCommand) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            return beginBatchEditInternal();
        }
        return applying$iv;
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        this.batchDepth--;
        if (this.batchDepth == 0 && (!this.editCommands.isEmpty())) {
            this.eventCallback.onEditCommands(CollectionsKt.toMutableList((Collection) this.editCommands));
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int newCursorPosition) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(text), newCursorPosition));
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            addEditCommandWithBatch(new SetComposingRegionCommand(start, end));
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(text), newCursorPosition));
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(beforeLength, afterLength));
            return true;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            addEditCommandWithBatch(new DeleteSurroundingTextCommand(beforeLength, afterLength));
            return true;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            addEditCommandWithBatch(new SetSelectionCommand(start, end));
            return true;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            addEditCommandWithBatch(new FinishComposingTextCommand());
            return true;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            this.eventCallback.onKeyEvent(event);
            return true;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int maxChars, int flags) {
        String result = TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, maxChars).toString();
        return result;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int maxChars, int flags) {
        String result = TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, maxChars).toString();
        return result;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int flags) {
        if (TextRange.m4720getCollapsedimpl(this.mTextFieldValue.getSelection())) {
            return null;
        }
        CharSequence result = TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
        return result;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            Log.w(RecordingInputConnection_androidKt.TAG, "requestCursorUpdates is not supported");
            return false;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        this.extractedTextMonitorMode = (flags & 1) != 0;
        if (this.extractedTextMonitorMode) {
            this.currentExtractedTextRequestToken = request != null ? request.token : 0;
        }
        ExtractedText extractedText = InputState_androidKt.toExtractedText(this.mTextFieldValue);
        return extractedText;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            switch (id) {
                case R.id.selectAll:
                    addEditCommandWithBatch(new SetSelectionCommand(0, this.mTextFieldValue.getText().length()));
                    break;
                case R.id.cut:
                    sendSynthesizedKeyEvent(277);
                    break;
                case R.id.copy:
                    sendSynthesizedKeyEvent(278);
                    break;
                case R.id.paste:
                    sendSynthesizedKeyEvent(279);
                    break;
            }
            return false;
        }
        return applying$iv;
    }

    private final void sendSynthesizedKeyEvent(int code) {
        sendKeyEvent(new KeyEvent(0, code));
        sendKeyEvent(new KeyEvent(1, code));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int editorAction) {
        int imeAction;
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            switch (editorAction) {
                case 0:
                    imeAction = ImeAction.INSTANCE.m4884getDefaulteUduSuo();
                    break;
                case 1:
                default:
                    Log.w(RecordingInputConnection_androidKt.TAG, "IME sends unsupported Editor Action: " + editorAction);
                    imeAction = ImeAction.INSTANCE.m4884getDefaulteUduSuo();
                    break;
                case 2:
                    imeAction = ImeAction.INSTANCE.m4886getGoeUduSuo();
                    break;
                case 3:
                    imeAction = ImeAction.INSTANCE.m4890getSearcheUduSuo();
                    break;
                case 4:
                    imeAction = ImeAction.INSTANCE.m4891getSendeUduSuo();
                    break;
                case 5:
                    imeAction = ImeAction.INSTANCE.m4887getNexteUduSuo();
                    break;
                case 6:
                    imeAction = ImeAction.INSTANCE.m4885getDoneeUduSuo();
                    break;
                case 7:
                    imeAction = ImeAction.INSTANCE.m4889getPreviouseUduSuo();
                    break;
            }
            this.eventCallback.mo4898onImeActionKlQnJC8(imeAction);
            return true;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            return false;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            return this.autoCorrect;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            return false;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        return TextUtils.getCapsMode(this.mTextFieldValue.getText(), TextRange.m4724getMinimpl(this.mTextFieldValue.getSelection()), reqModes);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String action, Bundle data) {
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            return true;
        }
        return applying$iv;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
        Intrinsics.checkNotNullParameter(inputContentInfo, "inputContentInfo");
        boolean applying$iv = this.isActive;
        if (applying$iv) {
            return false;
        }
        return applying$iv;
    }

    private final void logDebug(String message) {
    }
}
