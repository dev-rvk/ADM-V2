package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ComposableMethod.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J:\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "parameterCount", "", "getParameterCount", "()I", "parameterTypes", "", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", "parameters", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "asMethod", "equals", "", "other", "hashCode", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public ComposableMethod(Method method, ComposableInfo composableInfo) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(composableInfo, "composableInfo");
        this.method = method;
        this.composableInfo = composableInfo;
    }

    /* renamed from: asMethod, reason: from getter */
    public final Method getMethod() {
        return this.method;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Parameter[] getParameters() {
        Parameter[] parameters = this.method.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "method.parameters");
        return (Parameter[]) ArraysKt.copyOfRange(parameters, 0, this.composableInfo.getRealParamsCount());
    }

    public final Class<?>[] getParameterTypes() {
        Class<?>[] parameterTypes = this.method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        return (Class[]) ArraysKt.copyOfRange(parameterTypes, 0, this.composableInfo.getRealParamsCount());
    }

    public final Object invoke(Composer composer, Object instance, Object... args) {
        Object obj;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(args, "args");
        ComposableInfo composableInfo = this.composableInfo;
        int realParamsCount = composableInfo.getRealParamsCount();
        int changedParams = composableInfo.getChangedParams();
        int defaultParams = composableInfo.getDefaultParams();
        int totalParams = this.method.getParameterTypes().length;
        int changedStartIndex = realParamsCount + 1;
        int defaultStartIndex = changedStartIndex + changedParams;
        Object[] objArr = new Integer[defaultParams];
        int i = 0;
        while (i < defaultParams) {
            int start = i * 31;
            int end = Math.min(start + 31, realParamsCount);
            Iterable $this$map$iv = RangesKt.until(start, end);
            int defaultParams2 = defaultParams;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterator<Integer> it = $this$map$iv.iterator();
            while (it.hasNext()) {
                int item$iv$iv = ((IntIterator) it).nextInt();
                int changedParams2 = changedParams;
                destination$iv$iv.add(Integer.valueOf((item$iv$iv >= args.length || args[item$iv$iv] == null) ? 1 : 0));
                changedParams = changedParams2;
            }
            int changedParams3 = changedParams;
            Iterable useDefault = (List) destination$iv$iv;
            Iterable $this$foldIndexed$iv = useDefault;
            int index$iv = 0;
            int accumulator$iv = 0;
            for (Object element$iv : $this$foldIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int mask = accumulator$iv;
                int i2 = mask | (((Number) element$iv).intValue() << index$iv);
                accumulator$iv = i2;
                index$iv = index$iv2;
            }
            int mask2 = accumulator$iv;
            objArr[i] = Integer.valueOf(mask2);
            i++;
            defaultParams = defaultParams2;
            changedParams = changedParams3;
        }
        Object[] arguments = new Object[totalParams];
        int i3 = 0;
        while (i3 < totalParams) {
            if (i3 >= 0 && i3 < realParamsCount) {
                if (i3 < 0 || i3 > ArraysKt.getLastIndex(args)) {
                    Class<?> cls = this.method.getParameterTypes()[i3];
                    Intrinsics.checkNotNullExpressionValue(cls, "method.parameterTypes[idx]");
                    obj = ComposableMethodKt.getDefaultValue(cls);
                } else {
                    obj = args[i3];
                }
            } else if (i3 == realParamsCount) {
                obj = composer;
            } else if (i3 == changedStartIndex) {
                obj = 0;
            } else if (changedStartIndex + 1 <= i3 && i3 < defaultStartIndex) {
                obj = 0;
            } else {
                if (!(defaultStartIndex <= i3 && i3 < totalParams)) {
                    throw new IllegalStateException("Unexpected index".toString());
                }
                obj = objArr[i3 - defaultStartIndex];
            }
            arguments[i3] = obj;
            i3++;
        }
        return this.method.invoke(instance, Arrays.copyOf(arguments, arguments.length));
    }

    public boolean equals(Object other) {
        if (other instanceof ComposableMethod) {
            return Intrinsics.areEqual(this.method, ((ComposableMethod) other).method);
        }
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
