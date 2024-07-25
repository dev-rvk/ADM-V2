package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010F\u001a\u00020GH\u0080@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0015\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0003H\u0000¢\u0006\u0002\bLJ%\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u0013H\u0000¢\u0006\u0002\bQJ\u0010\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u0013H\u0002J3\u0010T\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u00020G2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020G2\u0006\u00100\u001a\u00020\u0003H\u0000¢\u0006\u0002\b[J\u0011\u0010\\\u001a\u00020GH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010IJ%\u0010]\u001a\u00020G2\u0006\u0010K\u001a\u00020\u00132\b\b\u0002\u0010^\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\f\u0010a\u001a\u00020\u0003*\u00020\u0013H\u0002J\f\u0010b\u001a\u00020\u0003*\u00020\u0013H\u0002R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b$\u0010#R+\u0010'\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0010\u001a\u0004\b(\u0010#\"\u0004\b)\u0010*R+\u0010,\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0010\u001a\u0004\b-\u0010#\"\u0004\b.\u0010*R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b1\u0010\u0019R+\u00102\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R4\u00109\u001a\u0002082\u0006\u0010\b\u001a\u0002088@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0010\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010<R$\u0010>\u001a\u00020?8@X\u0080\u0084\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\b@\u0010\fR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac$material3_release", "()J", "setCenter--gyyYBs$material3_release", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getCurrentAngle$material3_release", "()Landroidx/compose/animation/core/Animatable;", "hour", "getHour", "()I", "hourAngle", "getHourAngle$material3_release", "()F", "setHourAngle$material3_release", "(F)V", "hourAngle$delegate", "hourForDisplay", "getHourForDisplay$material3_release", "is24hour", "()Z", "isAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/State;", "isAfternoonToggle", "isAfternoonToggle$material3_release", "setAfternoonToggle$material3_release", "(Z)V", "isAfternoonToggle$delegate", "isInnerCircle", "isInnerCircle$material3_release", "setInnerCircle$material3_release", "isInnerCircle$delegate", "minute", "getMinute", "minuteAngle", "getMinuteAngle$material3_release", "setMinuteAngle$material3_release", "minuteAngle$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/material3/Selection;", "selection", "getSelection-JiIwxys$material3_release", "setSelection-iHAOin8$material3_release", "(I)V", "selection$delegate", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos-RKDOV3M$material3_release", "selectorPos$delegate", "values", "", "getValues$material3_release", "()Ljava/util/List;", "animateToCurrent", "", "animateToCurrent$material3_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelected", "value", "isSelected$material3_release", "moveSelector", "x", "y", "maxDist", "moveSelector$material3_release", "offsetHour", "angle", "onTap", "autoSwitchToMinute", "onTap$material3_release", "(FFFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHour", "setHour$material3_release", "setMinute", "setMinute$material3_release", "settle", "update", "fromTap", "update$material3_release", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHour", "toMinute", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TimePickerState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: center$delegate, reason: from kotlin metadata */
    private final MutableState center;
    private final Animatable<Float, AnimationVector1D> currentAngle;

    /* renamed from: hourAngle$delegate, reason: from kotlin metadata */
    private final MutableState hourAngle;
    private final boolean is24hour;

    /* renamed from: isAfternoon$delegate, reason: from kotlin metadata */
    private final State isAfternoon;

    /* renamed from: isAfternoonToggle$delegate, reason: from kotlin metadata */
    private final MutableState isAfternoonToggle;

    /* renamed from: isInnerCircle$delegate, reason: from kotlin metadata */
    private final MutableState isInnerCircle;

    /* renamed from: minuteAngle$delegate, reason: from kotlin metadata */
    private final MutableState minuteAngle;
    private final MutatorMutex mutex;

    /* renamed from: selection$delegate, reason: from kotlin metadata */
    private final MutableState selection;

    /* renamed from: selectorPos$delegate, reason: from kotlin metadata */
    private final State selectorPos;

    public TimePickerState(int initialHour, int initialMinute, final boolean is24Hour) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        if (!(initialHour >= 0 && initialHour < 24)) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        }
        if (!(initialHour >= 0 && initialHour < 60)) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }
        this.is24hour = is24Hour;
        this.selectorPos = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<DpOffset>() { // from class: androidx.compose.material3.TimePickerState$selectorPos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ DpOffset invoke() {
                return DpOffset.m5273boximpl(m1916invokeRKDOV3M());
            }

            /* renamed from: invoke-RKDOV3M, reason: not valid java name */
            public final long m1916invokeRKDOV3M() {
                boolean inInnerCircle = TimePickerState.this.isInnerCircle$material3_release();
                float arg0$iv = Dp.m5218constructorimpl(TimePickerTokens.INSTANCE.m2482getClockDialSelectorHandleContainerSizeD9Ej5fM() / 2);
                float length = Dp.m5218constructorimpl(Dp.m5218constructorimpl(((is24Hour && inInnerCircle && Selection.m1695equalsimpl0(TimePickerState.this.m1912getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1699getHourJiIwxys())) ? TimePickerKt.InnerCircleRadius : TimePickerKt.OuterCircleSizeRadius) - arg0$iv) + arg0$iv);
                float other$iv = (float) Math.cos(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue());
                float arg0$iv2 = Dp.m5218constructorimpl(Dp.m5218constructorimpl(length * other$iv) + Dp.m5218constructorimpl(TimePickerTokens.INSTANCE.m2480getClockDialContainerSizeD9Ej5fM() / 2));
                float other$iv2 = (float) Math.sin(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue());
                return DpKt.m5239DpOffsetYgX7TsA(arg0$iv2, Dp.m5218constructorimpl(Dp.m5218constructorimpl(length * other$iv2) + Dp.m5218constructorimpl(TimePickerTokens.INSTANCE.m2480getClockDialContainerSizeD9Ej5fM() / 2)));
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m5327boximpl(IntOffset.INSTANCE.m5346getZeronOccac()), null, 2, null);
        this.center = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m1692boximpl(Selection.INSTANCE.m1699getHourJiIwxys()), null, 2, null);
        this.selection = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialHour > 12 && !is24Hour), null, 2, null);
        this.isAfternoonToggle = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialHour >= 12), null, 2, null);
        this.isInnerCircle = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(((initialHour * 0.5235988f) % 12) - 1.5707964f), null, 2, null);
        this.hourAngle = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf((initialMinute * 0.10471976f) - 1.5707964f), null, 2, null);
        this.minuteAngle = mutableStateOf$default6;
        this.mutex = new MutatorMutex();
        this.isAfternoon = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerState$isAfternoon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf((TimePickerState.this.getIs24hour() && TimePickerState.this.isInnerCircle$material3_release()) || TimePickerState.this.isAfternoonToggle$material3_release());
            }
        });
        this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, null);
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    /* renamed from: is24hour, reason: from getter */
    public final boolean getIs24hour() {
        return this.is24hour;
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    /* renamed from: getSelectorPos-RKDOV3M$material3_release, reason: not valid java name */
    public final long m1913getSelectorPosRKDOV3M$material3_release() {
        State $this$getValue$iv = this.selectorPos;
        return ((DpOffset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: getCenter-nOcc-ac$material3_release, reason: not valid java name */
    public final long m1911getCenternOccac$material3_release() {
        State $this$getValue$iv = this.center;
        return ((IntOffset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: setCenter--gyyYBs$material3_release, reason: not valid java name */
    public final void m1914setCentergyyYBs$material3_release(long j) {
        MutableState $this$setValue$iv = this.center;
        $this$setValue$iv.setValue(IntOffset.m5327boximpl(j));
    }

    public final List<Integer> getValues$material3_release() {
        return Selection.m1695equalsimpl0(m1912getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1700getMinuteJiIwxys()) ? TimePickerKt.access$getMinutes$p() : TimePickerKt.access$getHours$p();
    }

    /* renamed from: getSelection-JiIwxys$material3_release, reason: not valid java name */
    public final int m1912getSelectionJiIwxys$material3_release() {
        State $this$getValue$iv = this.selection;
        return ((Selection) $this$getValue$iv.getValue()).m1698unboximpl();
    }

    /* renamed from: setSelection-iHAOin8$material3_release, reason: not valid java name */
    public final void m1915setSelectioniHAOin8$material3_release(int i) {
        MutableState $this$setValue$iv = this.selection;
        $this$setValue$iv.setValue(Selection.m1692boximpl(i));
    }

    public final boolean isAfternoonToggle$material3_release() {
        State $this$getValue$iv = this.isAfternoonToggle;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        MutableState $this$setValue$iv = this.isAfternoonToggle;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isInnerCircle$material3_release() {
        State $this$getValue$iv = this.isInnerCircle;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setInnerCircle$material3_release(boolean z) {
        MutableState $this$setValue$iv = this.isInnerCircle;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final float getHourAngle$material3_release() {
        State $this$getValue$iv = this.hourAngle;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    public final void setHourAngle$material3_release(float f) {
        MutableState $this$setValue$iv = this.hourAngle;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    public final float getMinuteAngle$material3_release() {
        State $this$getValue$iv = this.minuteAngle;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    public final void setMinuteAngle$material3_release(float f) {
        MutableState $this$setValue$iv = this.minuteAngle;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    private final boolean isAfternoon() {
        State $this$getValue$iv = this.isAfternoon;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    public final void setMinute$material3_release(int minute) {
        setMinuteAngle$material3_release((minute * 0.10471976f) - 1.5707964f);
    }

    public final void setHour$material3_release(int hour) {
        setInnerCircle$material3_release(hour > 12 || hour == 0);
        setHourAngle$material3_release(((hour * 0.5235988f) % 12) - 1.5707964f);
    }

    public final void moveSelector$material3_release(float x, float y, float maxDist) {
        if (!Selection.m1695equalsimpl0(m1912getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1699getHourJiIwxys()) || !this.is24hour) {
            return;
        }
        setInnerCircle$material3_release(TimePickerKt.access$dist(x, y, IntOffset.m5336getXimpl(m1911getCenternOccac$material3_release()), IntOffset.m5337getYimpl(m1911getCenternOccac$material3_release())) < maxDist);
    }

    public final boolean isSelected$material3_release(int value) {
        if (Selection.m1695equalsimpl0(m1912getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1700getMinuteJiIwxys())) {
            return value == getMinute();
        }
        return getHour() == (isAfternoon() ? 12 : 0) + value;
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, continuation);
    }

    public final Object update$material3_release(float value, boolean fromTap, Continuation<? super Unit> continuation) {
        Object mutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, value, fromTap, null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToCurrent$material3_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof androidx.compose.material3.TimePickerState$animateToCurrent$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = (androidx.compose.material3.TimePickerState$animateToCurrent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = new androidx.compose.material3.TimePickerState$animateToCurrent$1
            r0.<init>(r12, r13)
        L19:
            r13 = r0
            java.lang.Object r8 = r13.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            switch(r0) {
                case 0: goto L3e;
                case 1: goto L32;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L2d:
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lb8
        L32:
            float r0 = r13.F$0
            java.lang.Object r1 = r13.L$0
            androidx.compose.material3.TimePickerState r1 = (androidx.compose.material3.TimePickerState) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r10 = r0
            r11 = r1
            goto L95
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r12
            int r0 = r1.m1912getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r2 = androidx.compose.material3.Selection.INSTANCE
            int r2 = r2.m1699getHourJiIwxys()
            boolean r0 = androidx.compose.material3.Selection.m1695equalsimpl0(r0, r2)
            if (r0 == 0) goto L5f
            float r0 = r1.getMinuteAngle$material3_release()
            float r2 = r1.getHourAngle$material3_release()
            kotlin.Pair r0 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r0, r2)
            goto L6b
        L5f:
            float r0 = r1.getHourAngle$material3_release()
            float r2 = r1.getMinuteAngle$material3_release()
            kotlin.Pair r0 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r0, r2)
        L6b:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r3 = r1.currentAngle
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r13.L$0 = r1
            r13.F$0 = r0
            r5 = 1
            r13.label = r5
            java.lang.Object r2 = r3.snapTo(r4, r13)
            if (r2 != r9) goto L93
            return r9
        L93:
            r10 = r0
            r11 = r1
        L95:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r11.currentAngle
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            r2 = 0
            r3 = 6
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 0
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r2, r5, r3, r5)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r13.L$0 = r5
            r3 = 2
            r13.label = r3
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = r13
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto Lb8
            return r9
        Lb8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.animateToCurrent$material3_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int hourForDisplay(int hour) {
        if (this.is24hour && isInnerCircle$material3_release() && hour == 0) {
            return 12;
        }
        if (this.is24hour) {
            return hour % 24;
        }
        if (hour % 12 == 0) {
            return 12;
        }
        return isAfternoon() ? hour - 12 : hour;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetHour(float angle) {
        float ret = 1.5707964f + angle;
        return ret < 0.0f ? 6.2831855f + ret : ret;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float $this$toHour) {
        double totalOffset = 0.2617994f + 1.5707963267948966d;
        return ((int) (($this$toHour + totalOffset) / 0.5235988f)) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float $this$toMinute) {
        double totalOffset = 0.05235988f + 1.5707963267948966d;
        return ((int) (($this$toMinute + totalOffset) / 0.10471976f)) % 60;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object settle(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof androidx.compose.material3.TimePickerState$settle$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.material3.TimePickerState$settle$1 r0 = (androidx.compose.material3.TimePickerState$settle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$settle$1 r0 = new androidx.compose.material3.TimePickerState$settle$1
            r0.<init>(r12, r13)
        L19:
            r13 = r0
            java.lang.Object r8 = r13.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            switch(r0) {
                case 0: goto L3f;
                case 1: goto L31;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L2d:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L92
        L31:
            java.lang.Object r0 = r13.L$1
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.lang.Object r1 = r13.L$0
            androidx.compose.material3.TimePickerState r1 = (androidx.compose.material3.TimePickerState) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r10 = r0
            r11 = r1
            goto L6d
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r12
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r1.currentAngle
            java.lang.Object r0 = r0.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r2 = r1.getMinuteAngle$material3_release()
            kotlin.Pair r0 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r0, r2)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r2 = r1.currentAngle
            java.lang.Object r3 = r0.getFirst()
            r13.L$0 = r1
            r13.L$1 = r0
            r4 = 1
            r13.label = r4
            java.lang.Object r2 = r2.snapTo(r3, r13)
            if (r2 != r9) goto L6b
            return r9
        L6b:
            r10 = r0
            r11 = r1
        L6d:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r11.currentAngle
            java.lang.Object r1 = r10.getSecond()
            r2 = 0
            r3 = 6
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 0
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r2, r5, r3, r5)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r13.L$0 = r5
            r13.L$1 = r5
            r3 = 2
            r13.label = r3
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = r13
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L92
            return r9
        L92:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.settle(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0028. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onTap$material3_release(float r16, float r17, float r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.onTap$material3_release(float, float, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(new Function2<SaverScope, TimePickerState, List<? extends Object>>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final List<Object> invoke(SaverScope Saver, TimePickerState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return CollectionsKt.listOf(Integer.valueOf(it.getHour()), Integer.valueOf(it.getMinute()), Boolean.valueOf(it.getIs24hour()));
                }
            }, new Function1<List, TimePickerState>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TimePickerState invoke(List list) {
                    return invoke2((List<? extends Object>) list);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final TimePickerState invoke2(List<? extends Object> value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    Object obj = value.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj).intValue();
                    Object obj2 = value.get(1);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) obj2).intValue();
                    Object obj3 = value.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    return new TimePickerState(intValue, intValue2, ((Boolean) obj3).booleanValue());
                }
            });
        }
    }
}
