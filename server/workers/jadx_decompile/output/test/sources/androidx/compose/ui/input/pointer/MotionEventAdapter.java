package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MotionEventAdapter.android.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0010J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010(\u001a\u00020\u001f*\u00020\u00152\u0006\u0010!\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "()V", "canHover", "Landroid/util/SparseBooleanArray;", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "nextId", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousSource", "", "previousToolType", "addFreshIds", "", "motionEvent", "Landroid/view/MotionEvent;", "clearOnDeviceChange", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui_release", "createPointerInputEventData", "index", "pressed", "", "endStream", "pointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "removeStaleIds", "hasPointerId", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MotionEventAdapter {
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray canHover = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private int previousToolType = -1;
    private int previousSource = -1;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    /* renamed from: getMotionEventToComposePointerIdMap$ui_release, reason: from getter */
    public final SparseLongArray getMotionEventToComposePointerIdMap() {
        return this.motionEventToComposePointerIdMap;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int upIndex;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        int action = motionEvent.getActionMasked();
        if (action == 3) {
            this.motionEventToComposePointerIdMap.clear();
            this.canHover.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean isHover = action == 10 || action == 7 || action == 9;
        boolean isScroll = action == 8;
        if (isHover) {
            int hoverId = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.canHover.put(hoverId, true);
        }
        switch (action) {
            case 1:
                upIndex = 0;
                break;
            case 6:
                upIndex = motionEvent.getActionIndex();
                break;
            default:
                upIndex = -1;
                break;
        }
        this.pointers.clear();
        int i = 0;
        int pointerCount = motionEvent.getPointerCount();
        while (i < pointerCount) {
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i, (isHover || i == upIndex || (isScroll && motionEvent.getButtonState() == 0)) ? false : true));
            i++;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int pointerId) {
        this.canHover.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                    SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                    long j = this.nextId;
                    this.nextId = 1 + j;
                    sparseLongArray.put(pointerId, j);
                    if (motionEvent.getToolType(actionIndex) == 3) {
                        this.canHover.put(pointerId, true);
                        return;
                    }
                    return;
                }
                return;
            case 9:
                int pointerId2 = motionEvent.getPointerId(0);
                if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
                    SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
                    long j2 = this.nextId;
                    this.nextId = 1 + j2;
                    sparseLongArray2.put(pointerId2, j2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 1:
            case 6:
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (!this.canHover.get(pointerId, false)) {
                    this.motionEventToComposePointerIdMap.delete(pointerId);
                    this.canHover.delete(pointerId);
                    break;
                }
                break;
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            int i = this.motionEventToComposePointerIdMap.size();
            while (true) {
                i--;
                if (-1 < i) {
                    int pointerId2 = this.motionEventToComposePointerIdMap.keyAt(i);
                    if (!hasPointerId(motionEvent, pointerId2)) {
                        this.motionEventToComposePointerIdMap.removeAt(i);
                        this.canHover.delete(pointerId2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent $this$hasPointerId, int pointerId) {
        int pointerCount = $this$hasPointerId.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            if ($this$hasPointerId.getPointerId(i) == pointerId) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m3999getComposePointerId_I2yYro(int motionEventPointerId) {
        long newId;
        int pointerIndex = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (pointerIndex >= 0) {
            newId = this.motionEventToComposePointerIdMap.valueAt(pointerIndex);
        } else {
            newId = this.nextId;
            this.nextId = 1 + newId;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, newId);
        }
        return PointerId.m4049constructorimpl(newId);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType != this.previousToolType || source != this.previousSource) {
            this.previousToolType = toolType;
            this.previousSource = source;
            this.canHover.clear();
            this.motionEventToComposePointerIdMap.clear();
        }
    }

    private final PointerInputEventData createPointerInputEventData(PositionCalculator positionCalculator, MotionEvent motionEvent, int index, boolean pressed) {
        long position;
        long rawPosition;
        int toolType;
        long scrollDelta;
        int motionEventPointerId = motionEvent.getPointerId(index);
        long pointerId = m3999getComposePointerId_I2yYro(motionEventPointerId);
        float pressure = motionEvent.getPressure(index);
        long position2 = OffsetKt.Offset(motionEvent.getX(index), motionEvent.getY(index));
        if (index == 0) {
            long rawPosition2 = OffsetKt.Offset(motionEvent.getRawX(), motionEvent.getRawY());
            position = positionCalculator.mo4149screenToLocalMKHz9U(rawPosition2);
            rawPosition = rawPosition2;
        } else if (Build.VERSION.SDK_INT >= 29) {
            long rawPosition3 = MotionEventHelper.INSTANCE.m4000toRawOffsetdBAh8RU(motionEvent, index);
            position = positionCalculator.mo4149screenToLocalMKHz9U(rawPosition3);
            rawPosition = rawPosition3;
        } else {
            long rawPosition4 = positionCalculator.mo4148localToScreenMKHz9U(position2);
            position = position2;
            rawPosition = rawPosition4;
        }
        switch (motionEvent.getToolType(index)) {
            case 0:
                toolType = PointerType.INSTANCE.m4147getUnknownT8wyACA();
                break;
            case 1:
                toolType = PointerType.INSTANCE.m4146getTouchT8wyACA();
                break;
            case 2:
                toolType = PointerType.INSTANCE.m4145getStylusT8wyACA();
                break;
            case 3:
                toolType = PointerType.INSTANCE.m4144getMouseT8wyACA();
                break;
            case 4:
                toolType = PointerType.INSTANCE.m4143getEraserT8wyACA();
                break;
            default:
                toolType = PointerType.INSTANCE.m4147getUnknownT8wyACA();
                break;
        }
        ArrayList historical = new ArrayList(motionEvent.getHistorySize());
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            int pos = i;
            float x = motionEvent.getHistoricalX(index, pos);
            float y = motionEvent.getHistoricalY(index, pos);
            if ((Float.isInfinite(x) || Float.isNaN(x)) ? false : true) {
                if ((Float.isInfinite(y) || Float.isNaN(y)) ? false : true) {
                    HistoricalChange historicalChange = new HistoricalChange(motionEvent.getHistoricalEventTime(pos), OffsetKt.Offset(x, y), null);
                    historical.add(historicalChange);
                }
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            scrollDelta = OffsetKt.Offset(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f);
        } else {
            scrollDelta = Offset.INSTANCE.m2726getZeroF1C5BW0();
        }
        boolean issuesEnterExit = this.canHover.get(motionEvent.getPointerId(index), false);
        return new PointerInputEventData(pointerId, motionEvent.getEventTime(), rawPosition, position, pressed, pressure, toolType, issuesEnterExit, historical, scrollDelta, null);
    }
}
