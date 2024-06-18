package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo $this$updateWithEmojiCompat) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo($this$updateWithEmojiCompat);
        }
    }

    public static final void update(EditorInfo $this$update, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int imeAction = imeOptions.getImeAction();
        int i = 6;
        if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4884getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4888getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4886getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4887getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4889getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4890getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4891getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m4872equalsimpl0(imeAction, ImeAction.INSTANCE.m4885getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        $this$update.imeOptions = i;
        int keyboardType = imeOptions.getKeyboardType();
        if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4937getTextPjHm6EE())) {
            $this$update.inputType = 1;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4930getAsciiPjHm6EE())) {
            $this$update.inputType = 1;
            $this$update.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4933getNumberPjHm6EE())) {
            $this$update.inputType = 2;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4936getPhonePjHm6EE())) {
            $this$update.inputType = 3;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4938getUriPjHm6EE())) {
            $this$update.inputType = 17;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4932getEmailPjHm6EE())) {
            $this$update.inputType = 33;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4935getPasswordPjHm6EE())) {
            $this$update.inputType = 129;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4934getNumberPasswordPjHm6EE())) {
            $this$update.inputType = 18;
        } else if (KeyboardType.m4917equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4931getDecimalPjHm6EE())) {
            $this$update.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag($this$update.inputType, 1)) {
            $this$update.inputType |= 131072;
            if (ImeAction.m4872equalsimpl0(imeOptions.getImeAction(), ImeAction.INSTANCE.m4884getDefaulteUduSuo())) {
                $this$update.imeOptions |= BasicMeasure.EXACTLY;
            }
        }
        if (hasFlag($this$update.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            if (KeyboardCapitalization.m4902equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m4910getCharactersIUNYP9k())) {
                $this$update.inputType |= 4096;
            } else if (KeyboardCapitalization.m4902equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m4913getWordsIUNYP9k())) {
                $this$update.inputType |= 8192;
            } else if (KeyboardCapitalization.m4902equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m4912getSentencesIUNYP9k())) {
                $this$update.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                $this$update.inputType |= 32768;
            }
        }
        $this$update.initialSelStart = TextRange.m4726getStartimpl(textFieldValue.getSelection());
        $this$update.initialSelEnd = TextRange.m4721getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText($this$update, textFieldValue.getText());
        $this$update.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer $this$asExecutor) {
        Intrinsics.checkNotNullParameter($this$asExecutor, "<this>");
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$1($this$asExecutor, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$1(Choreographer this_asExecutor, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this_asExecutor, "$this_asExecutor");
        this_asExecutor.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }

    private static final boolean hasFlag(int bits, int flag) {
        return (bits & flag) == flag;
    }
}
