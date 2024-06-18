package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardActionRunner.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "()V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "runAction", "runAction-KlQnJC8", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    private TextInputSession inputSession;
    public KeyboardActions keyboardActions;

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions) {
        Intrinsics.checkNotNullParameter(keyboardActions, "<set-?>");
        this.keyboardActions = keyboardActions;
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final void setFocusManager(FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(focusManager, "<set-?>");
        this.focusManager = focusManager;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final void setInputSession(TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    /* renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final void m765runActionKlQnJC8(int imeAction) {
        Function1 keyboardAction;
        Unit unit = null;
        if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4885getDoneeUduSuo())) {
            keyboardAction = getKeyboardActions().getOnDone();
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4886getGoeUduSuo())) {
            keyboardAction = getKeyboardActions().getOnGo();
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4887getNexteUduSuo())) {
            keyboardAction = getKeyboardActions().getOnNext();
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4889getPreviouseUduSuo())) {
            keyboardAction = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4890getSearcheUduSuo())) {
            keyboardAction = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4891getSendeUduSuo())) {
            keyboardAction = getKeyboardActions().getOnSend();
        } else {
            if (!(ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4884getDefaulteUduSuo()) ? true : ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4888getNoneeUduSuo()))) {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
            keyboardAction = null;
        }
        if (keyboardAction != null) {
            keyboardAction.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            mo764defaultKeyboardActionKlQnJC8(imeAction);
        }
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo764defaultKeyboardActionKlQnJC8(int imeAction) {
        if (!ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4887getNexteUduSuo())) {
            if (!ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4889getPreviouseUduSuo())) {
                if (!ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4885getDoneeUduSuo())) {
                    if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4886getGoeUduSuo()) ? true : ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4890getSearcheUduSuo()) ? true : ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4891getSendeUduSuo()) ? true : ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4884getDefaulteUduSuo())) {
                        return;
                    }
                    ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4888getNoneeUduSuo());
                    return;
                } else {
                    TextInputSession textInputSession = this.inputSession;
                    if (textInputSession != null) {
                        textInputSession.hideSoftwareKeyboard();
                        return;
                    }
                    return;
                }
            }
            getFocusManager().mo2647moveFocus3ESFkO8(FocusDirection.INSTANCE.m2644getPreviousdhqQ8s());
            return;
        }
        getFocusManager().mo2647moveFocus3ESFkO8(FocusDirection.INSTANCE.m2642getNextdhqQ8s());
    }
}
