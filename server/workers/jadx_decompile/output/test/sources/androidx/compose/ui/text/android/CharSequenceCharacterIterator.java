package androidx.compose.ui.text.android;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.text.CharacterIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharSequenceCharacterIterator.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\t\u0010\u0012\u001a\u00020\fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/android/CharSequenceCharacterIterator;", "Ljava/text/CharacterIterator;", "charSequence", "", "start", "", "end", "(Ljava/lang/CharSequence;II)V", "index", "clone", "", "current", "", "first", "getBeginIndex", "getEndIndex", "getIndex", "last", "next", "previous", "setIndex", "position", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CharSequenceCharacterIterator implements CharacterIterator {
    private final CharSequence charSequence;
    private final int end;
    private int index;
    private final int start;

    public CharSequenceCharacterIterator(CharSequence charSequence, int start, int end) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        this.charSequence = charSequence;
        this.start = start;
        this.end = end;
        this.index = this.start;
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.index = this.start;
        return current();
    }

    @Override // java.text.CharacterIterator
    public char last() {
        if (this.start == this.end) {
            this.index = this.end;
            return CharCompanionObject.MAX_VALUE;
        }
        this.index = this.end - 1;
        return this.charSequence.charAt(this.index);
    }

    @Override // java.text.CharacterIterator
    public char current() {
        return this.index == this.end ? CharCompanionObject.MAX_VALUE : this.charSequence.charAt(this.index);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        this.index++;
        if (this.index >= this.end) {
            this.index = this.end;
            return CharCompanionObject.MAX_VALUE;
        }
        return this.charSequence.charAt(this.index);
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        if (this.index <= this.start) {
            return CharCompanionObject.MAX_VALUE;
        }
        this.index--;
        return this.charSequence.charAt(this.index);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int position) {
        int i = this.start;
        boolean z = false;
        if (position <= this.end && i <= position) {
            z = true;
        }
        if (z) {
            this.index = position;
            return current();
        }
        throw new IllegalArgumentException("invalid position");
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.start;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.index;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            Object clone = super.clone();
            Intrinsics.checkNotNullExpressionValue(clone, "{\n            @Suppress(…  super.clone()\n        }");
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
