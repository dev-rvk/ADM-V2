package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PersistentVectorBuilder.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010+\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0018\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001d\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J=\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0-H\u0002¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\u000bH\u0000¢\u0006\u0002\b2JG\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0002\u00107J[\u00103\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010<J/\u0010=\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010@J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000BH\u0096\u0002J\u001e\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070D2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0016J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010!\u001a\u00020\u000bH\u0016J'\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010HJ-\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010J\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\u0015\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010\u0012J\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010NJ5\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010PJ?\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ/\u0010U\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010VJM\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0014\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070-H\u0002¢\u0006\u0002\u0010YJE\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002¢\u0006\u0002\u0010[J?\u0010\\\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010_J?\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010aJu\u0010b\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u0002062\u0014\u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070i2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070iH\u0002¢\u0006\u0002\u0010jJ\u001c\u0010k\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dH\u0002JA\u0010k\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002¢\u0006\u0002\u0010lJ\u0016\u0010k\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J,\u0010m\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002J\u001a\u0010o\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dJ\u0015\u0010p\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0002\u00100J=\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ9\u0010r\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010sJ/\u0010t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\b\u0010R\u001a\u00020\u000bH\u0002J\u001e\u0010u\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010vJE\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010x\u001a\u00028\u00002\u0006\u0010y\u001a\u000206H\u0002¢\u0006\u0002\u00107JU\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010{\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010|Jl\u0010}\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u000e\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u007f\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0003\u0010\u0080\u0001J\b\u0010n\u001a\u00020\u000bH\u0002J\u0010\u0010n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R0\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "E", "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "root", "getRoot$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getRootShift$runtime_release", "()I", "setRootShift$runtime_release", "(I)V", "size", "getSize", "tail", "getTail$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "bufferFor", "(I)[Ljava/lang/Object;", "build", "copyToBuffer", "buffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getModCount", "getModCount$runtime_release", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "buffers", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "isMutable", "([Ljava/lang/Object;)Z", "iterator", "", "leafBufferIterator", "", "listIterator", "", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBuffer", "mutableBufferWith", "(Ljava/lang/Object;)[Ljava/lang/Object;", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "pullLastBuffer", "rootSize", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "recyclableRemoveAll", "predicate", "Lkotlin/Function1;", "bufferSize", "toBufferSize", "bufferRef", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "removeAll", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "removeAllFromTail", "tailSize", "removeAllWithPredicate", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "retainFirst", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;
    private PersistentList<? extends E> vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;

    public PersistentVectorBuilder(PersistentList<? extends E> vector, Object[] vectorRoot, Object[] vectorTail, int rootShift) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        Intrinsics.checkNotNullParameter(vectorTail, "vectorTail");
        this.vector = vector;
        this.vectorRoot = vectorRoot;
        this.vectorTail = vectorTail;
        this.rootShift = rootShift;
        this.ownership = new MutabilityOwnership();
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    /* renamed from: getRootShift$runtime_release, reason: from getter */
    public final int getRootShift() {
        return this.rootShift;
    }

    public final void setRootShift$runtime_release(int i) {
        this.rootShift = i;
    }

    /* renamed from: getRoot$runtime_release, reason: from getter */
    public final Object[] getRoot() {
        return this.root;
    }

    /* renamed from: getTail$runtime_release, reason: from getter */
    public final Object[] getTail() {
        return this.tail;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentList<E> build() {
        PersistentVector persistentVector;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            persistentVector = this.vector;
        } else {
            this.ownership = new MutabilityOwnership();
            this.vectorRoot = this.root;
            this.vectorTail = this.tail;
            if (this.root == null) {
                if (this.tail.length == 0) {
                    persistentVector = UtilsKt.persistentVectorOf();
                } else {
                    Object[] copyOf = Arrays.copyOf(this.tail, size());
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    persistentVector = new SmallPersistentVector(copyOf);
                }
            } else {
                Object[] objArr = this.root;
                Intrinsics.checkNotNull(objArr);
                persistentVector = new PersistentVector(objArr, this.tail, size(), this.rootShift);
            }
        }
        this.vector = persistentVector;
        return this.vector;
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final int tailSize(int size) {
        if (size <= 32) {
            return size;
        }
        return size - UtilsKt.rootSize(size);
    }

    private final int tailSize() {
        return tailSize(size());
    }

    private final boolean isMutable(Object[] buffer) {
        return buffer.length == 33 && buffer[32] == this.ownership;
    }

    private final Object[] makeMutable(Object[] buffer) {
        if (buffer == null) {
            return mutableBuffer();
        }
        if (isMutable(buffer)) {
            return buffer;
        }
        return ArraysKt.copyInto$default(buffer, mutableBuffer(), 0, 0, RangesKt.coerceAtMost(buffer.length, 32), 6, (Object) null);
    }

    private final Object[] makeMutableShiftingRight(Object[] buffer, int distance) {
        if (isMutable(buffer)) {
            return ArraysKt.copyInto(buffer, buffer, distance, 0, 32 - distance);
        }
        return ArraysKt.copyInto(buffer, mutableBuffer(), distance, 0, 32 - distance);
    }

    private final Object[] mutableBufferWith(Object element) {
        Object[] buffer = new Object[33];
        buffer[0] = element;
        buffer[32] = this.ownership;
        return buffer;
    }

    private final Object[] mutableBuffer() {
        Object[] buffer = new Object[33];
        buffer[32] = this.ownership;
        return buffer;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        this.modCount++;
        int tailSize = tailSize();
        if (tailSize < 32) {
            Object[] mutableTail = makeMutable(this.tail);
            mutableTail[tailSize] = element;
            this.tail = mutableTail;
            this.size = size() + 1;
        } else {
            Object[] newTail = mutableBufferWith(element);
            pushFilledTail(this.root, this.tail, newTail);
        }
        return true;
    }

    private final void pushFilledTail(Object[] root, Object[] filledTail, Object[] newTail) {
        if ((size() >> 5) > (1 << this.rootShift)) {
            this.root = pushTail(mutableBufferWith(root), filledTail, this.rootShift + 5);
            this.tail = newTail;
            this.rootShift += 5;
            this.size = size() + 1;
            return;
        }
        if (root == null) {
            this.root = filledTail;
            this.tail = newTail;
            this.size = size() + 1;
        } else {
            this.root = pushTail(root, filledTail, this.rootShift);
            this.tail = newTail;
            this.size = size() + 1;
        }
    }

    private final Object[] pushTail(Object[] root, Object[] tail, int shift) {
        int index = UtilsKt.indexSegment(size() - 1, shift);
        Object[] mutableRoot = makeMutable(root);
        if (shift == 5) {
            mutableRoot[index] = tail;
        } else {
            mutableRoot[index] = pushTail((Object[]) mutableRoot[index], tail, shift - 5);
        }
        return mutableRoot;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        this.modCount++;
        int tailSize = tailSize();
        Iterator elementsIterator = elements.iterator();
        if (32 - tailSize >= elements.size()) {
            this.tail = copyToBuffer(makeMutable(this.tail), tailSize, elementsIterator);
            this.size = size() + elements.size();
        } else {
            int buffersSize = ((elements.size() + tailSize) - 1) / 32;
            Object[][] buffers = new Object[buffersSize];
            buffers[0] = copyToBuffer(makeMutable(this.tail), tailSize, elementsIterator);
            for (int index = 1; index < buffersSize; index++) {
                buffers[index] = copyToBuffer(mutableBuffer(), 0, elementsIterator);
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), buffers);
            this.tail = copyToBuffer(mutableBuffer(), 0, elementsIterator);
            this.size = size() + elements.size();
        }
        return true;
    }

    private final Object[] copyToBuffer(Object[] buffer, int bufferIndex, Iterator<? extends Object> sourceIterator) {
        for (int index = bufferIndex; index < 32 && sourceIterator.hasNext(); index++) {
            buffer[index] = sourceIterator.next();
        }
        return buffer;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] root, int rootSize, Object[][] buffers) {
        Object[] mutableRoot;
        Iterator buffersIterator = ArrayIteratorKt.iterator(buffers);
        if ((rootSize >> 5) < (1 << this.rootShift)) {
            mutableRoot = pushBuffers(root, rootSize, this.rootShift, buffersIterator);
        } else {
            mutableRoot = makeMutable(root);
        }
        while (buffersIterator.hasNext()) {
            this.rootShift += 5;
            mutableRoot = mutableBufferWith(mutableRoot);
            pushBuffers(mutableRoot, 1 << this.rootShift, this.rootShift, buffersIterator);
        }
        return mutableRoot;
    }

    private final Object[] pushBuffers(Object[] root, int rootSize, int shift, Iterator<Object[]> buffersIterator) {
        if (!buffersIterator.hasNext()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(shift >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (shift == 0) {
            return buffersIterator.next();
        }
        Object[] mutableRoot = makeMutable(root);
        int index = UtilsKt.indexSegment(rootSize, shift);
        mutableRoot[index] = pushBuffers((Object[]) mutableRoot[index], rootSize, shift - 5, buffersIterator);
        while (true) {
            index++;
            if (index >= 32 || !buffersIterator.hasNext()) {
                break;
            }
            mutableRoot[index] = pushBuffers((Object[]) mutableRoot[index], 0, shift - 5, buffersIterator);
        }
        return mutableRoot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            add(element);
            return;
        }
        this.modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            insertIntoTail(this.root, index - rootSize, element);
            return;
        }
        ObjectRef elementCarry = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        Object[] newRest = insertIntoRoot(objArr, this.rootShift, index, element, elementCarry);
        insertIntoTail(newRest, 0, elementCarry.getValue());
    }

    private final void insertIntoTail(Object[] root, int index, E element) {
        int tailSize = tailSize();
        Object[] mutableTail = makeMutable(this.tail);
        if (tailSize < 32) {
            ArraysKt.copyInto(this.tail, mutableTail, index + 1, index, tailSize);
            mutableTail[index] = element;
            this.root = root;
            this.tail = mutableTail;
            this.size = size() + 1;
            return;
        }
        Object lastElement = this.tail[31];
        ArraysKt.copyInto(this.tail, mutableTail, index + 1, index, 31);
        mutableTail[index] = element;
        pushFilledTail(root, mutableTail, mutableBufferWith(lastElement));
    }

    private final Object[] insertIntoRoot(Object[] root, int shift, int index, Object element, ObjectRef elementCarry) {
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            elementCarry.setValue(root[31]);
            Object[] mutableRoot = ArraysKt.copyInto(root, makeMutable(root), bufferIndex + 1, bufferIndex, 31);
            mutableRoot[bufferIndex] = element;
            return mutableRoot;
        }
        Object[] mutableRoot2 = makeMutable(root);
        int lowerLevelShift = shift - 5;
        Object obj = mutableRoot2[bufferIndex];
        String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        mutableRoot2[bufferIndex] = insertIntoRoot((Object[]) obj, lowerLevelShift, index, element, elementCarry);
        int i = bufferIndex + 1;
        while (i < 32 && mutableRoot2[i] != null) {
            Object obj2 = mutableRoot2[i];
            Intrinsics.checkNotNull(obj2, str);
            mutableRoot2[i] = insertIntoRoot((Object[]) obj2, lowerLevelShift, 0, elementCarry.getValue(), elementCarry);
            i++;
            str = str;
        }
        return mutableRoot2;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Object[] newTail;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        this.modCount++;
        int unaffectedElementsCount = (index >> 5) << 5;
        int buffersSize = (((size() - unaffectedElementsCount) + elements.size()) - 1) / 32;
        if (buffersSize == 0) {
            CommonFunctionsKt.m2595assert(index >= rootSize());
            int startIndex = index & 31;
            int endIndex = ((elements.size() + index) - 1) & 31;
            Object[] newTail2 = ArraysKt.copyInto(this.tail, makeMutable(this.tail), endIndex + 1, startIndex, tailSize());
            copyToBuffer(newTail2, startIndex, elements.iterator());
            this.tail = newTail2;
            this.size = size() + elements.size();
            return true;
        }
        Object[][] buffers = new Object[buffersSize];
        int tailSize = tailSize();
        int newTailSize = tailSize(size() + elements.size());
        if (index >= rootSize()) {
            Object[] newTail3 = mutableBuffer();
            splitToBuffers(elements, index, this.tail, tailSize, buffers, buffersSize, newTail3);
            newTail = newTail3;
        } else if (newTailSize <= tailSize) {
            Object[] newTail4 = ArraysKt.copyInto(this.tail, mutableBuffer(), 0, tailSize - newTailSize, tailSize);
            int rightShift = 32 - (tailSize - newTailSize);
            Object[] lastBuffer = makeMutableShiftingRight(this.tail, rightShift);
            buffers[buffersSize - 1] = lastBuffer;
            insertIntoRoot(elements, index, rightShift, buffers, buffersSize - 1, lastBuffer);
            newTail = newTail4;
        } else {
            int rightShift2 = newTailSize - tailSize;
            Object[] newTail5 = makeMutableShiftingRight(this.tail, rightShift2);
            insertIntoRoot(elements, index, rightShift2, buffers, buffersSize, newTail5);
            newTail = newTail5;
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, unaffectedElementsCount, buffers);
        this.tail = newTail;
        this.size = size() + elements.size();
        return true;
    }

    private final void insertIntoRoot(Collection<? extends E> elements, int index, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        Object[] newNextBuffer;
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int startLeafIndex = index >> 5;
        Object[] startLeaf = shiftLeafBuffers(startLeafIndex, rightShift, buffers, nullBuffers, nextBuffer);
        int lastLeafIndex = (rootSize() >> 5) - 1;
        int newNullBuffers = nullBuffers - (lastLeafIndex - startLeafIndex);
        if (newNullBuffers < nullBuffers) {
            Object[] objArr = buffers[newNullBuffers];
            Intrinsics.checkNotNull(objArr);
            newNextBuffer = objArr;
        } else {
            newNextBuffer = nextBuffer;
        }
        splitToBuffers(elements, index, startLeaf, 32, buffers, newNullBuffers, newNextBuffer);
    }

    private final Object[] shiftLeafBuffers(int startLeafIndex, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int leafCount = rootSize() >> 5;
        ListIterator leafBufferIterator = leafBufferIterator(leafCount);
        int bufferIndex = nullBuffers;
        Object[] buffer = nextBuffer;
        while (leafBufferIterator.previousIndex() != startLeafIndex) {
            Object[] currentBuffer = leafBufferIterator.previous();
            ArraysKt.copyInto(currentBuffer, buffer, 0, 32 - rightShift, 32);
            buffer = makeMutableShiftingRight(currentBuffer, rightShift);
            bufferIndex--;
            buffers[bufferIndex] = buffer;
        }
        return leafBufferIterator.previous();
    }

    private final void splitToBuffers(Collection<? extends E> elements, int index, Object[] startBuffer, int startBufferSize, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        if (!(nullBuffers >= 1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Object[] firstBuffer = makeMutable(startBuffer);
        buffers[0] = firstBuffer;
        Object[] newNextBuffer = nextBuffer;
        int newNullBuffers = nullBuffers;
        int startBufferStartIndex = index & 31;
        int endBufferEndIndex = ((index + elements.size()) - 1) & 31;
        int elementsToShift = startBufferSize - startBufferStartIndex;
        if (endBufferEndIndex + elementsToShift < 32) {
            ArraysKt.copyInto(firstBuffer, newNextBuffer, endBufferEndIndex + 1, startBufferStartIndex, startBufferSize);
        } else {
            int toCopyToLast = ((endBufferEndIndex + elementsToShift) - 32) + 1;
            if (nullBuffers == 1) {
                newNextBuffer = firstBuffer;
            } else {
                Object[] newNextBuffer2 = mutableBuffer();
                newNullBuffers--;
                buffers[newNullBuffers] = newNextBuffer2;
                newNextBuffer = newNextBuffer2;
            }
            ArraysKt.copyInto(firstBuffer, nextBuffer, 0, startBufferSize - toCopyToLast, startBufferSize);
            ArraysKt.copyInto(firstBuffer, newNextBuffer, endBufferEndIndex + 1, startBufferStartIndex, startBufferSize - toCopyToLast);
        }
        Iterator elementsIterator = elements.iterator();
        copyToBuffer(firstBuffer, startBufferStartIndex, elementsIterator);
        for (int i = 1; i < newNullBuffers; i++) {
            buffers[i] = copyToBuffer(mutableBuffer(), 0, elementsIterator);
        }
        copyToBuffer(newNextBuffer, 0, elementsIterator);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return (E) bufferFor(index)[index & 31];
    }

    private final Object[] bufferFor(int index) {
        if (rootSize() <= index) {
            return this.tail;
        }
        Object[] buffer = this.root;
        Intrinsics.checkNotNull(buffer);
        for (int shift = this.rootShift; shift > 0; shift -= 5) {
            Object obj = buffer[UtilsKt.indexSegment(index, shift)];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            buffer = (Object[]) obj;
        }
        return buffer;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        this.modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            return (E) removeFromTailAt(this.root, rootSize, this.rootShift, index - rootSize);
        }
        ObjectRef objectRef = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, index, objectRef), rootSize, this.rootShift, 0);
        return (E) objectRef.getValue();
    }

    private final Object removeFromTailAt(Object[] root, int rootSize, int shift, int index) {
        int tailSize = size() - rootSize;
        CommonFunctionsKt.m2595assert(index < tailSize);
        if (tailSize == 1) {
            Object removedElement = this.tail[0];
            pullLastBufferFromRoot(root, rootSize, shift);
            return removedElement;
        }
        Object removedElement2 = this.tail[index];
        Object[] mutableTail = ArraysKt.copyInto(this.tail, makeMutable(this.tail), index, index + 1, tailSize);
        mutableTail[tailSize - 1] = null;
        this.root = root;
        this.tail = mutableTail;
        this.size = (rootSize + tailSize) - 1;
        this.rootShift = shift;
        return removedElement2;
    }

    private final Object[] removeFromRootAt(Object[] root, int shift, int index, ObjectRef tailCarry) {
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            Object removedElement = root[bufferIndex];
            Object[] mutableRoot = ArraysKt.copyInto(root, makeMutable(root), bufferIndex, bufferIndex + 1, 32);
            mutableRoot[31] = tailCarry.getValue();
            tailCarry.setValue(removedElement);
            return mutableRoot;
        }
        int bufferLastIndex = 31;
        if (root[31] == null) {
            bufferLastIndex = UtilsKt.indexSegment(rootSize() - 1, shift);
        }
        Object[] mutableRoot2 = makeMutable(root);
        int lowerLevelShift = shift - 5;
        int i = bufferLastIndex;
        int i2 = bufferIndex + 1;
        if (i2 <= i) {
            while (true) {
                Object obj = mutableRoot2[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                mutableRoot2[i] = removeFromRootAt((Object[]) obj, lowerLevelShift, 0, tailCarry);
                if (i == i2) {
                    break;
                }
                i--;
            }
        }
        Object obj2 = mutableRoot2[bufferIndex];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        mutableRoot2[bufferIndex] = removeFromRootAt((Object[]) obj2, lowerLevelShift, index, tailCarry);
        return mutableRoot2;
    }

    private final void pullLastBufferFromRoot(Object[] root, int rootSize, int shift) {
        Object[] objArr;
        if (shift == 0) {
            this.root = null;
            if (root != null) {
                objArr = root;
            } else {
                objArr = new Object[0];
            }
            this.tail = objArr;
            this.size = rootSize;
            this.rootShift = shift;
            return;
        }
        ObjectRef tailCarry = new ObjectRef(null);
        Intrinsics.checkNotNull(root);
        Object[] newRoot = pullLastBuffer(root, shift, rootSize, tailCarry);
        Intrinsics.checkNotNull(newRoot);
        Object value = tailCarry.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) value;
        this.size = rootSize;
        if (newRoot[1] == null) {
            this.root = (Object[]) newRoot[0];
            this.rootShift = shift - 5;
        } else {
            this.root = newRoot;
            this.rootShift = shift;
        }
    }

    private final Object[] pullLastBuffer(Object[] root, int shift, int rootSize, ObjectRef tailCarry) {
        Object[] newBufferAtIndex;
        int bufferIndex = UtilsKt.indexSegment(rootSize - 1, shift);
        if (shift == 5) {
            tailCarry.setValue(root[bufferIndex]);
            newBufferAtIndex = null;
        } else {
            Object obj = root[bufferIndex];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            newBufferAtIndex = pullLastBuffer((Object[]) obj, shift - 5, rootSize, tailCarry);
        }
        if (newBufferAtIndex == null && bufferIndex == 0) {
            return null;
        }
        Object[] mutableRoot = makeMutable(root);
        mutableRoot[bufferIndex] = newBufferAtIndex;
        return mutableRoot;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return removeAllWithPredicate(new Function1<E, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder$removeAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(E e) {
                return Boolean.valueOf(elements.contains(e));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((PersistentVectorBuilder$removeAll$1<E>) obj);
            }
        });
    }

    public final boolean removeAllWithPredicate(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean anyRemoved = removeAll(predicate);
        if (anyRemoved) {
            this.modCount++;
        }
        return anyRemoved;
    }

    private final boolean removeAll(Function1<? super E, Boolean> predicate) {
        Object[] newRoot;
        int tailSize = tailSize();
        ObjectRef bufferRef = new ObjectRef(null);
        if (this.root == null) {
            return removeAllFromTail(predicate, tailSize, bufferRef) != tailSize;
        }
        ListIterator leafIterator = leafBufferIterator(0);
        int bufferSize = 32;
        while (bufferSize == 32 && leafIterator.hasNext()) {
            bufferSize = removeAll(predicate, leafIterator.next(), 32, bufferRef);
        }
        if (bufferSize == 32) {
            CommonFunctionsKt.m2595assert(!leafIterator.hasNext());
            int newTailSize = removeAllFromTail(predicate, tailSize, bufferRef);
            if (newTailSize == 0) {
                pullLastBufferFromRoot(this.root, size(), this.rootShift);
            }
            return newTailSize != tailSize;
        }
        int unaffectedElementsCount = leafIterator.previousIndex() << 5;
        List buffers = new ArrayList();
        List recyclableBuffers = new ArrayList();
        int bufferSize2 = bufferSize;
        while (leafIterator.hasNext()) {
            Object[] leaf = leafIterator.next();
            bufferSize2 = recyclableRemoveAll(predicate, leaf, 32, bufferSize2, bufferRef, recyclableBuffers, buffers);
            unaffectedElementsCount = unaffectedElementsCount;
        }
        int unaffectedElementsCount2 = unaffectedElementsCount;
        int newTailSize2 = recyclableRemoveAll(predicate, this.tail, tailSize, bufferSize2, bufferRef, recyclableBuffers, buffers);
        Object value = bufferRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] newTail = (Object[]) value;
        ArraysKt.fill(newTail, (Object) null, newTailSize2, 32);
        if (buffers.isEmpty()) {
            newRoot = this.root;
            Intrinsics.checkNotNull(newRoot);
        } else {
            newRoot = pushBuffers(this.root, unaffectedElementsCount2, this.rootShift, buffers.iterator());
        }
        int newRootSize = unaffectedElementsCount2 + (buffers.size() << 5);
        this.root = retainFirst(newRoot, newRootSize);
        this.tail = newTail;
        this.size = newRootSize + newTailSize2;
        return true;
    }

    private final Object[] retainFirst(Object[] root, int size) {
        if (!((size & 31) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (size == 0) {
            this.rootShift = 0;
            return null;
        }
        int lastIndex = size - 1;
        Object[] newRoot = root;
        while ((lastIndex >> this.rootShift) == 0) {
            this.rootShift -= 5;
            Object obj = newRoot[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            newRoot = (Object[]) obj;
        }
        return nullifyAfter(newRoot, lastIndex, this.rootShift);
    }

    private final Object[] nullifyAfter(Object[] root, int index, int shift) {
        if (!(shift >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (shift == 0) {
            return root;
        }
        int lastIndex = UtilsKt.indexSegment(index, shift);
        Object obj = root[lastIndex];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object nullifyAfter = nullifyAfter((Object[]) obj, index, shift - 5);
        Object[] newRoot = root;
        if (lastIndex < 31 && newRoot[lastIndex + 1] != null) {
            if (isMutable(newRoot)) {
                ArraysKt.fill(newRoot, (Object) null, lastIndex + 1, 32);
            }
            newRoot = ArraysKt.copyInto(newRoot, mutableBuffer(), 0, 0, lastIndex + 1);
        }
        if (nullifyAfter != newRoot[lastIndex]) {
            Object[] newRoot2 = makeMutable(newRoot);
            newRoot2[lastIndex] = nullifyAfter;
            return newRoot2;
        }
        return newRoot;
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> predicate, int tailSize, ObjectRef bufferRef) {
        int newTailSize = removeAll(predicate, this.tail, tailSize, bufferRef);
        if (newTailSize == tailSize) {
            CommonFunctionsKt.m2595assert(bufferRef.getValue() == this.tail);
            return tailSize;
        }
        Object value = bufferRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] newTail = (Object[]) value;
        ArraysKt.fill(newTail, (Object) null, newTailSize, tailSize);
        this.tail = newTail;
        this.size = size() - (tailSize - newTailSize);
        return newTailSize;
    }

    private final int removeAll(Function1<? super E, Boolean> predicate, Object[] buffer, int bufferSize, ObjectRef bufferRef) {
        Object[] newBuffer = buffer;
        int newBufferSize = bufferSize;
        boolean anyRemoved = false;
        for (int index = 0; index < bufferSize; index++) {
            Object element = buffer[index];
            if (predicate.invoke(element).booleanValue()) {
                if (!anyRemoved) {
                    newBuffer = makeMutable(buffer);
                    newBufferSize = index;
                    anyRemoved = true;
                }
            } else if (anyRemoved) {
                newBuffer[newBufferSize] = element;
                newBufferSize++;
            }
        }
        bufferRef.setValue(newBuffer);
        return newBufferSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int recyclableRemoveAll(Function1<? super E, Boolean> predicate, Object[] buffer, int bufferSize, int toBufferSize, ObjectRef bufferRef, List<Object[]> recyclableBuffers, List<Object[]> buffers) {
        Object[] mutableBuffer;
        if (isMutable(buffer)) {
            recyclableBuffers.add(buffer);
        }
        Object value = bufferRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] toBuffer = (Object[]) value;
        Object[] newToBuffer = toBuffer;
        int newToBufferSize = toBufferSize;
        for (int index = 0; index < bufferSize; index++) {
            Object element = buffer[index];
            if (!predicate.invoke(element).booleanValue()) {
                if (newToBufferSize == 32) {
                    if (!recyclableBuffers.isEmpty()) {
                        mutableBuffer = recyclableBuffers.remove(recyclableBuffers.size() - 1);
                    } else {
                        mutableBuffer = mutableBuffer();
                    }
                    newToBuffer = mutableBuffer;
                    newToBufferSize = 0;
                }
                newToBuffer[newToBufferSize] = element;
                newToBufferSize++;
            }
        }
        bufferRef.setValue(newToBuffer);
        if (toBuffer != bufferRef.getValue()) {
            buffers.add(toBuffer);
        }
        return newToBufferSize;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        if (rootSize() <= index) {
            Object[] makeMutable = makeMutable(this.tail);
            if (makeMutable != this.tail) {
                this.modCount++;
            }
            int i = index & 31;
            E e = (E) makeMutable[i];
            makeMutable[i] = element;
            this.tail = makeMutable;
            return e;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        this.root = setInRoot(objArr, this.rootShift, index, element, objectRef);
        return (E) objectRef.getValue();
    }

    private final Object[] setInRoot(Object[] root, int shift, int index, E e, ObjectRef oldElementCarry) {
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        Object[] mutableRoot = makeMutable(root);
        if (shift == 0) {
            if (mutableRoot != root) {
                this.modCount++;
            }
            oldElementCarry.setValue(mutableRoot[bufferIndex]);
            mutableRoot[bufferIndex] = e;
            return mutableRoot;
        }
        Object obj = mutableRoot[bufferIndex];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        mutableRoot[bufferIndex] = setInRoot((Object[]) obj, shift - 5, index, e, oldElementCarry);
        return mutableRoot;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        return new PersistentVectorMutableIterator(this, index);
    }

    private final ListIterator<Object[]> leafBufferIterator(int index) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int leafCount = rootSize() >> 5;
        ListImplementation.checkPositionIndex$runtime_release(index, leafCount);
        if (this.rootShift == 0) {
            Object[] objArr = this.root;
            Intrinsics.checkNotNull(objArr);
            return new SingleElementListIterator(objArr, index);
        }
        int trieHeight = this.rootShift / 5;
        Object[] objArr2 = this.root;
        Intrinsics.checkNotNull(objArr2);
        return new TrieIterator(objArr2, index, leafCount, trieHeight);
    }
}
