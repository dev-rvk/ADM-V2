package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransformGestureDetector.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bø\u0001\u0001¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\u0002*\u00020\u0006ø\u0001\u0001¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a\u0084\u0001\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@ø\u0001\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "centroid", "pan", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    public static final Object detectTransformGestures(PointerInputScope $this$detectTransformGestures, boolean panZoomLock, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectTransformGestures, new TransformGestureDetectorKt$detectTransformGestures$2(panZoomLock, function4, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent $this$calculateRotation) {
        long previousPosition;
        long currentCentroid;
        int pointerCount;
        float f;
        Intrinsics.checkNotNullParameter($this$calculateRotation, "<this>");
        List $this$fastSumBy$iv = $this$calculateRotation.getChanges();
        int sum$iv = 0;
        int index$iv$iv = 0;
        int size = $this$fastSumBy$iv.size();
        while (true) {
            int i = 0;
            if (index$iv$iv >= size) {
                break;
            }
            Object item$iv$iv = $this$fastSumBy$iv.get(index$iv$iv);
            PointerInputChange it = (PointerInputChange) item$iv$iv;
            if (it.getPreviousPressed() && it.getPressed()) {
                i = 1;
            }
            sum$iv += i;
            index$iv$iv++;
        }
        int pointerCount2 = sum$iv;
        if (pointerCount2 < 2) {
            return 0.0f;
        }
        long currentCentroid2 = calculateCentroid($this$calculateRotation, true);
        long previousCentroid = calculateCentroid($this$calculateRotation, false);
        float rotation = 0.0f;
        float rotationWeight = 0.0f;
        List $this$fastForEach$iv = $this$calculateRotation.getChanges();
        int index$iv = 0;
        int size2 = $this$fastForEach$iv.size();
        while (index$iv < size2) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (!change.getPressed() || !change.getPreviousPressed()) {
                previousPosition = currentCentroid2;
                currentCentroid = previousCentroid;
                pointerCount = pointerCount2;
            } else {
                long currentPosition = change.getPosition();
                long previousPosition2 = change.getPreviousPosition();
                long previousOffset = Offset.m2714minusMKHz9U(previousPosition2, previousCentroid);
                previousPosition = currentCentroid2;
                currentCentroid = previousCentroid;
                pointerCount = pointerCount2;
                long currentOffset = Offset.m2714minusMKHz9U(currentPosition, previousPosition);
                float previousAngle = m355anglek4lQ0M(previousOffset);
                float currentAngle = m355anglek4lQ0M(currentOffset);
                float angleDiff = currentAngle - previousAngle;
                float weight = Offset.m2708getDistanceimpl(Offset.m2715plusMKHz9U(currentOffset, previousOffset)) / 2.0f;
                if (angleDiff > 180.0f) {
                    f = angleDiff - 360.0f;
                } else {
                    f = angleDiff < -180.0f ? angleDiff + 360.0f : angleDiff;
                }
                rotation += f * weight;
                rotationWeight += weight;
            }
            index$iv++;
            currentCentroid2 = previousPosition;
            pointerCount2 = pointerCount;
            previousCentroid = currentCentroid;
        }
        if (rotationWeight == 0.0f) {
            return 0.0f;
        }
        return rotation / rotationWeight;
    }

    /* renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m355anglek4lQ0M(long $this$angle_u2dk_u2d4lQ0M) {
        if (Offset.m2710getXimpl($this$angle_u2dk_u2d4lQ0M) == 0.0f) {
            if (Offset.m2711getYimpl($this$angle_u2dk_u2d4lQ0M) == 0.0f) {
                return 0.0f;
            }
        }
        return ((-((float) Math.atan2(Offset.m2710getXimpl($this$angle_u2dk_u2d4lQ0M), Offset.m2711getYimpl($this$angle_u2dk_u2d4lQ0M)))) * 180.0f) / 3.1415927f;
    }

    public static final float calculateZoom(PointerEvent $this$calculateZoom) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$calculateZoom, "<this>");
        boolean z2 = true;
        float currentCentroidSize = calculateCentroidSize($this$calculateZoom, true);
        float previousCentroidSize = calculateCentroidSize($this$calculateZoom, false);
        if (currentCentroidSize == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return 1.0f;
        }
        if (previousCentroidSize != 0.0f) {
            z2 = false;
        }
        if (z2) {
            return 1.0f;
        }
        return currentCentroidSize / previousCentroidSize;
    }

    public static final long calculatePan(PointerEvent $this$calculatePan) {
        Intrinsics.checkNotNullParameter($this$calculatePan, "<this>");
        long currentCentroid = calculateCentroid($this$calculatePan, true);
        if (Offset.m2707equalsimpl0(currentCentroid, Offset.INSTANCE.m2725getUnspecifiedF1C5BW0())) {
            return Offset.INSTANCE.m2726getZeroF1C5BW0();
        }
        long previousCentroid = calculateCentroid($this$calculatePan, false);
        return Offset.m2714minusMKHz9U(currentCentroid, previousCentroid);
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent $this$calculateCentroidSize, boolean useCurrent) {
        Intrinsics.checkNotNullParameter($this$calculateCentroidSize, "<this>");
        long centroid = calculateCentroid($this$calculateCentroidSize, useCurrent);
        if (Offset.m2707equalsimpl0(centroid, Offset.INSTANCE.m2725getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        float distanceToCentroid = 0.0f;
        int distanceWeight = 0;
        List $this$fastForEach$iv = $this$calculateCentroidSize.getChanges();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (change.getPressed() && change.getPreviousPressed()) {
                long position = useCurrent ? change.getPosition() : change.getPreviousPosition();
                distanceToCentroid += Offset.m2708getDistanceimpl(Offset.m2714minusMKHz9U(position, centroid));
                distanceWeight++;
            }
        }
        return distanceToCentroid / distanceWeight;
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent $this$calculateCentroid, boolean useCurrent) {
        Intrinsics.checkNotNullParameter($this$calculateCentroid, "<this>");
        long centroid = Offset.INSTANCE.m2726getZeroF1C5BW0();
        int centroidWeight = 0;
        List $this$fastForEach$iv = $this$calculateCentroid.getChanges();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (change.getPressed() && change.getPreviousPressed()) {
                long position = useCurrent ? change.getPosition() : change.getPreviousPosition();
                centroid = Offset.m2715plusMKHz9U(centroid, position);
                centroidWeight++;
            }
        }
        if (centroidWeight == 0) {
            return Offset.INSTANCE.m2725getUnspecifiedF1C5BW0();
        }
        return Offset.m2705divtuRUvjQ(centroid, centroidWeight);
    }
}
