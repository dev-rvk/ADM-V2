package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: VelocityTracker.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a(\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00072\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u0011\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0082\b\u001a2\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0000\u001a\u0012\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e\u001a\u0014\u0010\u001f\u001a\u00020\u0003*\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002\u001a,\u0010!\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\"2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0001H\u0082\n¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0003*\u00020\bH\u0082\b\u001a4\u0010'\u001a\u00020\u001b*\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\"2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u0003H\u0082\n¢\u0006\u0002\u0010)\u001a1\u0010'\u001a\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u00072\u0006\u0010+\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010.\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*\u0018\b\u0002\u0010\u0006\"\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0012\u0004\u0012\u00020\b0\u0007*\f\b\u0002\u0010/\"\u00020\b2\u00020\b¨\u00060"}, d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "Matrix", "", "", "Landroidx/compose/ui/input/pointer/util/Vector;", "rows", "cols", "(II)[[F", "calculateImpulseVelocity", "dataPoints", "time", "sampleCount", "isDataDifferential", "", "kineticEnergyToVelocity", "kineticEnergy", "polyFitLeastSquares", "x", "y", "degree", "coefficients", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/pointer/PointerInputChange;", "dot", "a", "get", "Landroidx/compose/ui/input/pointer/util/Matrix;", "row", "col", "([[FII)F", "norm", "set", "value", "([[FIIF)V", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "", "dataPoint", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "Vector", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void set(DataPointAtTime[] $this$set, int index, long time, float dataPoint) {
        DataPointAtTime currentEntry = $this$set[index];
        if (currentEntry == null) {
            $this$set[index] = new DataPointAtTime(time, dataPoint);
        } else {
            currentEntry.setTime(time);
            currentEntry.setDataPoint(dataPoint);
        }
    }

    public static final void addPointerInputChange(VelocityTracker $this$addPointerInputChange, PointerInputChange event) {
        Intrinsics.checkNotNullParameter($this$addPointerInputChange, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            $this$addPointerInputChange.m4162setCurrentPointerPositionAccumulatork4lQ0M$ui_release(event.getPosition());
            $this$addPointerInputChange.resetTracking();
        }
        long previousPointerPosition = event.getPreviousPosition();
        List $this$fastForEach$iv = event.getHistorical();
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            HistoricalChange it = (HistoricalChange) item$iv;
            long historicalDelta = Offset.m2714minusMKHz9U(it.getPosition(), previousPointerPosition);
            previousPointerPosition = it.getPosition();
            $this$addPointerInputChange.m4162setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2715plusMKHz9U($this$addPointerInputChange.getCurrentPointerPositionAccumulator(), historicalDelta));
            $this$addPointerInputChange.m4159addPositionUv8p0NA(it.getUptimeMillis(), $this$addPointerInputChange.getCurrentPointerPositionAccumulator());
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv;
        }
        long delta = Offset.m2714minusMKHz9U(event.getPosition(), previousPointerPosition);
        $this$addPointerInputChange.m4162setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2715plusMKHz9U($this$addPointerInputChange.getCurrentPointerPositionAccumulator(), delta));
        $this$addPointerInputChange.m4159addPositionUv8p0NA(event.getUptimeMillis(), $this$addPointerInputChange.getCurrentPointerPositionAccumulator());
    }

    public static /* synthetic */ float[] polyFitLeastSquares$default(float[] fArr, float[] fArr2, int i, int i2, float[] fArr3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            fArr3 = new float[RangesKt.coerceAtLeast(i2 + 1, 0)];
        }
        return polyFitLeastSquares(fArr, fArr2, i, i2, fArr3);
    }

    public static final float[] polyFitLeastSquares(float[] x, float[] y, int sampleCount, int degree, float[] coefficients) {
        float norm;
        float norm2;
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(coefficients, "coefficients");
        if (degree < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        }
        if (sampleCount == 0) {
            throw new IllegalArgumentException("At least one point must be provided");
        }
        int truncatedDegree = degree >= sampleCount ? sampleCount - 1 : degree;
        int n = truncatedDegree + 1;
        float[][] a = new float[n];
        for (int i = 0; i < n; i++) {
            a[i] = new float[sampleCount];
        }
        for (int h = 0; h < sampleCount; h++) {
            a[0][h] = 1.0f;
            for (int i2 = 1; i2 < n; i2++) {
                int row$iv = i2 - 1;
                float value$iv = a[row$iv][h] * x[h];
                a[i2][h] = value$iv;
            }
        }
        float[][] q = new float[n];
        for (int i3 = 0; i3 < n; i3++) {
            q[i3] = new float[sampleCount];
        }
        float[][] r = new float[n];
        for (int i4 = 0; i4 < n; i4++) {
            r[i4] = new float[n];
        }
        for (int j = 0; j < n; j++) {
            float[] w = q[j];
            float[] aw = a[j];
            for (int h2 = 0; h2 < sampleCount; h2++) {
                w[h2] = aw[h2];
            }
            for (int i5 = 0; i5 < j; i5++) {
                float[] z = q[i5];
                float dot = dot(w, z);
                for (int h3 = 0; h3 < sampleCount; h3++) {
                    w[h3] = w[h3] - (z[h3] * dot);
                }
            }
            float norm3 = (float) Math.sqrt(dot(w, w));
            if (norm3 < 1.0E-6f) {
                throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
            }
            float inverseNorm = 1.0f / norm3;
            for (int h4 = 0; h4 < sampleCount; h4++) {
                w[h4] = w[h4] * inverseNorm;
            }
            float[] v = r[j];
            int i6 = 0;
            while (i6 < n) {
                if (i6 < j) {
                    norm = norm3;
                    norm2 = 0.0f;
                } else {
                    norm = norm3;
                    norm2 = dot(w, a[i6]);
                }
                v[i6] = norm2;
                i6++;
                norm3 = norm;
            }
        }
        for (int i7 = n - 1; -1 < i7; i7--) {
            coefficients[i7] = dot(q[i7], y);
            int j2 = n - 1;
            int i8 = i7 + 1;
            if (i8 <= j2) {
                while (true) {
                    coefficients[i7] = coefficients[i7] - (r[i7][j2] * coefficients[j2]);
                    if (j2 != i8) {
                        j2--;
                    }
                }
            }
            coefficients[i7] = coefficients[i7] / r[i7][i7];
        }
        return coefficients;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateImpulseVelocity(float[] dataPoints, float[] time, int sampleCount, boolean isDataDifferential) {
        float dataPointsDelta;
        if (sampleCount < 2) {
            return 0.0f;
        }
        if (sampleCount == 2) {
            if (time[0] == time[1]) {
                return 0.0f;
            }
            if (isDataDifferential) {
                dataPointsDelta = dataPoints[0];
            } else {
                dataPointsDelta = dataPoints[0] - dataPoints[1];
            }
            return dataPointsDelta / (time[0] - time[1]);
        }
        float work = 0.0f;
        for (int i = sampleCount - 1; i > 0; i--) {
            if (!(time[i] == time[i + (-1)])) {
                float vPrev = Math.signum(work) * ((float) Math.sqrt(2 * Math.abs(work)));
                float dataPointsDelta2 = isDataDifferential ? -dataPoints[i - 1] : dataPoints[i] - dataPoints[i - 1];
                float vCurr = dataPointsDelta2 / (time[i] - time[i - 1]);
                work += (vCurr - vPrev) * Math.abs(vCurr);
                if (i == sampleCount - 1) {
                    work *= 0.5f;
                }
            }
        }
        return Math.signum(work) * ((float) Math.sqrt(2 * Math.abs(work)));
    }

    private static final float kineticEnergyToVelocity(float kineticEnergy) {
        return Math.signum(kineticEnergy) * ((float) Math.sqrt(2 * Math.abs(kineticEnergy)));
    }

    private static final float dot(float[] $this$dot, float[] a) {
        float result = 0.0f;
        int length = $this$dot.length;
        for (int i = 0; i < length; i++) {
            result += $this$dot[i] * a[i];
        }
        return result;
    }

    private static final float norm(float[] $this$norm) {
        return (float) Math.sqrt(dot($this$norm, $this$norm));
    }

    private static final float[][] Matrix(int rows, int cols) {
        float[][] fArr = new float[rows];
        for (int i = 0; i < rows; i++) {
            fArr[i] = new float[cols];
        }
        return fArr;
    }

    private static final float get(float[][] $this$get, int row, int col) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        return $this$get[row][col];
    }

    private static final void set(float[][] $this$set, int row, int col, float value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        $this$set[row][col] = value;
    }
}
