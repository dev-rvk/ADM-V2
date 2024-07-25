package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeadKeyCombiner.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/DeadKeyCombiner;", "", "()V", "deadKeyCode", "", "Ljava/lang/Integer;", "consume", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "consume-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DeadKeyCombiner {
    private Integer deadKeyCode;

    /* renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m761consumeZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int codePoint = KeyEvent_androidKt.m3937getUtf16CodePointZmokQxo(event);
        if ((Integer.MIN_VALUE & codePoint) != 0) {
            this.deadKeyCode = Integer.valueOf(Integer.MAX_VALUE & codePoint);
            return null;
        }
        Integer localDeadKeyCode = this.deadKeyCode;
        if (localDeadKeyCode != null) {
            this.deadKeyCode = null;
            Integer valueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(localDeadKeyCode.intValue(), codePoint));
            int it = valueOf.intValue();
            Integer num = it == 0 ? null : valueOf;
            if (num != null) {
                return num;
            }
            return Integer.valueOf(codePoint);
        }
        return Integer.valueOf(codePoint);
    }
}
