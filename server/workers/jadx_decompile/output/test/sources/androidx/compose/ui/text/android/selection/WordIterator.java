package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WordIterator.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", "start", "", "end", "locale", "Ljava/util/Locale;", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "iterator", "Ljava/text/BreakIterator;", "checkOffsetIsValid", "", "offset", "getBeginning", "getPrevWordBeginningOnTwoWordsBoundary", "", "getEnd", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterLetterOrDigit", "isAfterPunctuation", "isOnLetterOrDigit", "isOnPunctuation", "isPunctuationEndBoundary", "isPunctuationStartBoundary", "nextBoundary", "prevBoundary", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WordIterator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int WINDOW_WIDTH = 50;
    private final CharSequence charSequence;
    private final int end;
    private final BreakIterator iterator;
    private final int start;

    public WordIterator(CharSequence charSequence, int start, int end, Locale locale) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        this.charSequence = charSequence;
        if (!(start >= 0 && start <= this.charSequence.length())) {
            throw new IllegalArgumentException("input start index is outside the CharSequence".toString());
        }
        if (!(end >= 0 && end <= this.charSequence.length())) {
            throw new IllegalArgumentException("input end index is outside the CharSequence".toString());
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        Intrinsics.checkNotNullExpressionValue(wordInstance, "getWordInstance(locale)");
        this.iterator = wordInstance;
        this.start = Math.max(0, start - 50);
        this.end = Math.min(this.charSequence.length(), end + 50);
        this.iterator.setText(new CharSequenceCharacterIterator(this.charSequence, start, end));
    }

    public final int nextBoundary(int offset) {
        checkOffsetIsValid(offset);
        return this.iterator.following(offset);
    }

    public final int prevBoundary(int offset) {
        checkOffsetIsValid(offset);
        return this.iterator.preceding(offset);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int offset) {
        return getBeginning(offset, true);
    }

    public final int getNextWordEndOnTwoWordBoundary(int offset) {
        return getEnd(offset, true);
    }

    public final int getPunctuationBeginning(int offset) {
        checkOffsetIsValid(offset);
        int result = offset;
        while (result != -1 && !isPunctuationStartBoundary(result)) {
            result = prevBoundary(result);
        }
        return result;
    }

    public final int getPunctuationEnd(int offset) {
        checkOffsetIsValid(offset);
        int result = offset;
        while (result != -1 && !isPunctuationEndBoundary(result)) {
            result = nextBoundary(result);
        }
        return result;
    }

    public final boolean isAfterPunctuation(int offset) {
        if (!(offset <= this.end && this.start + 1 <= offset)) {
            return false;
        }
        int codePoint = Character.codePointBefore(this.charSequence, offset);
        return INSTANCE.isPunctuation$ui_text_release(codePoint);
    }

    public final boolean isOnPunctuation(int offset) {
        if (!(offset < this.end && this.start <= offset)) {
            return false;
        }
        int codePoint = Character.codePointAt(this.charSequence, offset);
        return INSTANCE.isPunctuation$ui_text_release(codePoint);
    }

    private final int getBeginning(int offset, boolean getPrevWordBeginningOnTwoWordsBoundary) {
        checkOffsetIsValid(offset);
        if (isOnLetterOrDigit(offset)) {
            if (this.iterator.isBoundary(offset) && (!isAfterLetterOrDigit(offset) || !getPrevWordBeginningOnTwoWordsBoundary)) {
                return offset;
            }
            return this.iterator.preceding(offset);
        }
        if (isAfterLetterOrDigit(offset)) {
            return this.iterator.preceding(offset);
        }
        return -1;
    }

    private final int getEnd(int offset, boolean getNextWordEndOnTwoWordBoundary) {
        checkOffsetIsValid(offset);
        if (isAfterLetterOrDigit(offset)) {
            if (this.iterator.isBoundary(offset) && (!isOnLetterOrDigit(offset) || !getNextWordEndOnTwoWordBoundary)) {
                return offset;
            }
            return this.iterator.following(offset);
        }
        if (isOnLetterOrDigit(offset)) {
            return this.iterator.following(offset);
        }
        return -1;
    }

    private final boolean isPunctuationStartBoundary(int offset) {
        return isOnPunctuation(offset) && !isAfterPunctuation(offset);
    }

    private final boolean isPunctuationEndBoundary(int offset) {
        return !isOnPunctuation(offset) && isAfterPunctuation(offset);
    }

    private final boolean isAfterLetterOrDigit(int offset) {
        if (offset <= this.end && this.start + 1 <= offset) {
            int codePoint = Character.codePointBefore(this.charSequence, offset);
            if (Character.isLetterOrDigit(codePoint)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isOnLetterOrDigit(int offset) {
        if (offset < this.end && this.start <= offset) {
            int codePoint = Character.codePointAt(this.charSequence, offset);
            if (Character.isLetterOrDigit(codePoint)) {
                return true;
            }
        }
        return false;
    }

    private final void checkOffsetIsValid(int offset) {
        int i = this.start;
        boolean z = false;
        if (offset <= this.end && i <= offset) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("Invalid offset: " + offset + ". Valid range is [" + this.start + " , " + this.end + ']').toString());
        }
    }

    /* compiled from: WordIterator.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPunctuation$ui_text_release(int cp) {
            int type = Character.getType(cp);
            return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
        }
    }
}
