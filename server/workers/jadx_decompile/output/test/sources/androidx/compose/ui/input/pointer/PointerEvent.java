package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.internal.ViewUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerEvent.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010\"\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@@X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Ljava/util/List;)V", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "()I", "I", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "<set-?>", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> changes, InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        this.changes = changes;
        this.internalPointerEvent = internalPointerEvent;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        this.buttons = PointerButtons.m4002constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m4130constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : 0);
        this.type = m4008calculatePointerEventType7fucELk();
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    /* renamed from: getInternalPointerEvent$ui_release, reason: from getter */
    public final InternalPointerEvent getInternalPointerEvent() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return internalPointerEvent.getMotionEvent();
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointerEvent(List<PointerInputChange> changes) {
        this(changes, null);
        Intrinsics.checkNotNullParameter(changes, "changes");
    }

    /* renamed from: getButtons-ry648PA, reason: not valid java name and from getter */
    public final int getButtons() {
        return this.buttons;
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name and from getter */
    public final int getKeyboardModifiers() {
        return this.keyboardModifiers;
    }

    /* renamed from: getType-7fucELk, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release, reason: not valid java name */
    public final void m4012setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m4008calculatePointerEventType7fucELk() {
        MotionEvent motionEvent = getMotionEvent$ui_release();
        if (motionEvent != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    return PointerEventType.INSTANCE.m4025getPress7fucELk();
                case 1:
                case 6:
                    return PointerEventType.INSTANCE.m4026getRelease7fucELk();
                case 2:
                case 7:
                    return PointerEventType.INSTANCE.m4024getMove7fucELk();
                case 3:
                case 4:
                default:
                    return PointerEventType.INSTANCE.m4028getUnknown7fucELk();
                case 8:
                    return PointerEventType.INSTANCE.m4027getScroll7fucELk();
                case 9:
                    return PointerEventType.INSTANCE.m4022getEnter7fucELk();
                case 10:
                    return PointerEventType.INSTANCE.m4023getExit7fucELk();
            }
        }
        List $this$fastForEach$iv = this.changes;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange it = (PointerInputChange) item$iv;
            if (PointerEventKt.changedToUpIgnoreConsumed(it)) {
                return PointerEventType.INSTANCE.m4026getRelease7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(it)) {
                return PointerEventType.INSTANCE.m4025getPress7fucELk();
            }
        }
        return PointerEventType.INSTANCE.m4024getMove7fucELk();
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    public final PointerEvent copy(List<PointerInputChange> changes, MotionEvent motionEvent) {
        List $this$fastForEach$iv;
        int $i$f$fastForEach;
        boolean z;
        Intrinsics.checkNotNullParameter(changes, "changes");
        if (motionEvent == null) {
            return new PointerEvent(changes, null);
        }
        if (Intrinsics.areEqual(motionEvent, getMotionEvent$ui_release())) {
            return new PointerEvent(changes, this.internalPointerEvent);
        }
        LinkedHashMap map = new LinkedHashMap(changes.size());
        ArrayList pointerEventData = new ArrayList(changes.size());
        List $this$fastForEach$iv2 = changes;
        int $i$f$fastForEach2 = 0;
        int index$iv = 0;
        int size = $this$fastForEach$iv2.size();
        while (index$iv < size) {
            Object item$iv = $this$fastForEach$iv2.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            map.put(PointerId.m4048boximpl(change.getId()), change);
            ArrayList arrayList = pointerEventData;
            long id = change.getId();
            long uptimeMillis = change.getUptimeMillis();
            long position = change.getPosition();
            long position2 = change.getPosition();
            boolean pressed = change.getPressed();
            float pressure = change.getPressure();
            int type = change.getType();
            InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
            if (internalPointerEvent != null) {
                $this$fastForEach$iv = $this$fastForEach$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
                z = true;
                if (internalPointerEvent.m3998issuesEnterExitEvent0FcD4WY(change.getId())) {
                    arrayList.add(new PointerInputEventData(id, uptimeMillis, position, position2, pressed, pressure, type, z, null, 0L, ViewUtils.EDGE_TO_EDGE_FLAGS, null));
                    index$iv++;
                    $this$fastForEach$iv2 = $this$fastForEach$iv;
                    $i$f$fastForEach2 = $i$f$fastForEach;
                }
            } else {
                $this$fastForEach$iv = $this$fastForEach$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
            }
            z = false;
            arrayList.add(new PointerInputEventData(id, uptimeMillis, position, position2, pressed, pressure, type, z, null, 0L, ViewUtils.EDGE_TO_EDGE_FLAGS, null));
            index$iv++;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
            $i$f$fastForEach2 = $i$f$fastForEach;
        }
        PointerInputEvent pointerInputEvent = new PointerInputEvent(motionEvent.getEventTime(), pointerEventData, motionEvent);
        InternalPointerEvent event = new InternalPointerEvent(map, pointerInputEvent);
        return new PointerEvent(changes, event);
    }
}
