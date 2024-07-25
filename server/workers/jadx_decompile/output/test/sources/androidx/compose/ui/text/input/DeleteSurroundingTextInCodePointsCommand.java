package androidx.compose.ui.text.input;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditCommand.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int lengthBeforeCursor, int lengthAfterCursor) {
        this.lengthBeforeCursor = lengthBeforeCursor;
        this.lengthAfterCursor = lengthAfterCursor;
        if (!(this.lengthBeforeCursor >= 0 && this.lengthAfterCursor >= 0)) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + this.lengthBeforeCursor + " and " + this.lengthAfterCursor + " respectively.").toString());
        }
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer buffer) {
        boolean isSurrogatePair;
        boolean isSurrogatePair2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int beforeLenInChars = 0;
        int i = this.lengthBeforeCursor;
        for (int i2 = 0; i2 < i; i2++) {
            beforeLenInChars++;
            if (buffer.getSelectionStart() > beforeLenInChars) {
                char lead = buffer.get$ui_text_release((buffer.getSelectionStart() - beforeLenInChars) - 1);
                char trail = buffer.get$ui_text_release(buffer.getSelectionStart() - beforeLenInChars);
                isSurrogatePair2 = EditCommandKt.isSurrogatePair(lead, trail);
                if (isSurrogatePair2) {
                    beforeLenInChars++;
                }
            }
            if (beforeLenInChars == buffer.getSelectionStart()) {
                break;
            }
        }
        int afterLenInChars = 0;
        int i3 = this.lengthAfterCursor;
        for (int i4 = 0; i4 < i3; i4++) {
            afterLenInChars++;
            if (buffer.getSelectionEnd() + afterLenInChars < buffer.getLength$ui_text_release()) {
                char lead2 = buffer.get$ui_text_release((buffer.getSelectionEnd() + afterLenInChars) - 1);
                char trail2 = buffer.get$ui_text_release(buffer.getSelectionEnd() + afterLenInChars);
                isSurrogatePair = EditCommandKt.isSurrogatePair(lead2, trail2);
                if (isSurrogatePair) {
                    afterLenInChars++;
                }
            }
            if (buffer.getSelectionEnd() + afterLenInChars == buffer.getLength$ui_text_release()) {
                break;
            }
        }
        int i5 = buffer.getSelectionEnd();
        buffer.delete$ui_text_release(i5, buffer.getSelectionEnd() + afterLenInChars);
        buffer.delete$ui_text_release(buffer.getSelectionStart() - beforeLenInChars, buffer.getSelectionStart());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeleteSurroundingTextInCodePointsCommand) && this.lengthBeforeCursor == ((DeleteSurroundingTextInCodePointsCommand) other).lengthBeforeCursor && this.lengthAfterCursor == ((DeleteSurroundingTextInCodePointsCommand) other).lengthAfterCursor;
    }

    public int hashCode() {
        int result = this.lengthBeforeCursor;
        return (result * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}
