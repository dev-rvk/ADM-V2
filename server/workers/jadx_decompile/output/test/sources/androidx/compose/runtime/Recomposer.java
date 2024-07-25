package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 °\u00012\u00020\u0001:\n°\u0001±\u0001²\u0001³\u0001´\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020XH\u0002J\u0006\u0010Y\u001a\u00020ZJ\u0011\u0010[\u001a\u00020UH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\\J\u0011\u0010]\u001a\u00020UH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\\J\u0006\u0010^\u001a\u00020UJ\u0006\u0010_\u001a\u00020UJ*\u0010`\u001a\u00020U2\u0006\u0010a\u001a\u00020\u00172\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020U0c¢\u0006\u0002\bdH\u0010¢\u0006\u0004\be\u0010fJ:\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\u0006\u0010a\u001a\u00020\u00172\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010K2\f\u0010j\u001a\b\u0012\u0004\u0012\u0002Hh0cH\u0082\b¢\u0006\u0002\u0010kJ\u0015\u0010l\u001a\u00020U2\u0006\u0010m\u001a\u00020\u001aH\u0010¢\u0006\u0002\bnJ\u0010\u0010o\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010TH\u0002J\b\u0010p\u001a\u00020UH\u0002J\u0015\u0010q\u001a\u00020U2\u0006\u0010m\u001a\u00020\u001aH\u0010¢\u0006\u0002\brJ\u0015\u0010s\u001a\u00020U2\u0006\u0010a\u001a\u00020\u0017H\u0010¢\u0006\u0002\btJ\u0015\u0010u\u001a\u00020U2\u0006\u0010v\u001a\u00020wH\u0010¢\u0006\u0002\bxJ\u0011\u0010y\u001a\u00020UH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\\J\u001d\u0010z\u001a\u00020U2\u0006\u0010m\u001a\u00020\u001a2\u0006\u0010{\u001a\u00020\u001bH\u0010¢\u0006\u0002\b|J\u0017\u0010}\u001a\u0004\u0018\u00010\u001b2\u0006\u0010m\u001a\u00020\u001aH\u0010¢\u0006\u0002\b~J\u0006\u0010\u007f\u001a\u00020UJ\u0011\u0010\u0080\u0001\u001a\u00020U2\u0006\u0010a\u001a\u00020\u0017H\u0002J0\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170\u0082\u00012\u000e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0082\u00012\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010KH\u0002J#\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010a\u001a\u00020\u00172\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010KH\u0002J0\u0010\u0085\u0001\u001a\u00020U2\r\u0010\u0086\u0001\u001a\b0\u0087\u0001j\u0003`\u0088\u00012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00172\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u0012H\u0002J\u001e\u0010\u008b\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020U0\u008c\u00012\u0006\u0010a\u001a\u00020\u0017H\u0002JY\u0010\u008d\u0001\u001a\u00020U2D\u0010j\u001a@\b\u0001\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0017\u0012\u00150\u0090\u0001¢\u0006\u000f\b\u0091\u0001\u0012\n\b\u0092\u0001\u0012\u0005\b\b(\u0093\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020U0\u0094\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u008e\u0001¢\u0006\u0003\b\u0095\u0001H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0096\u0001J\t\u0010\u0097\u0001\u001a\u00020\u0012H\u0002J \u0010\u0097\u0001\u001a\u00020U2\u0014\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020U0\u008c\u0001H\u0082\bJ\u001f\u0010\u0099\u0001\u001a\u00020U2\u000e\u0010\u009a\u0001\u001a\t\u0012\u0005\u0012\u00030\u009b\u00010\"H\u0010¢\u0006\u0003\b\u009c\u0001J\u0017\u0010\u009d\u0001\u001a\u00020U2\u0006\u0010a\u001a\u00020\u0017H\u0010¢\u0006\u0003\b\u009e\u0001J\u0012\u0010\u009f\u0001\u001a\u00020U2\u0007\u0010 \u0001\u001a\u00020GH\u0002J\u0017\u0010¡\u0001\u001a\u00020U2\u0006\u0010a\u001a\u00020\u0017H\u0010¢\u0006\u0003\b¢\u0001J\u000b\u0010£\u0001\u001a\u0004\u0018\u000101H\u0002J\u0007\u0010¤\u0001\u001a\u00020UJ\t\u0010¥\u0001\u001a\u00020UH\u0002J'\u0010¦\u0001\u001a\u00020U2\b\u0010\u0093\u0001\u001a\u00030\u0090\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010©\u0001J\u0012\u0010ª\u0001\u001a\u00020UH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\\J\u001b\u0010«\u0001\u001a\u00020U2\u0006\u0010B\u001a\u00020\u0003H\u0087@ø\u0001\u0000¢\u0006\u0003\u0010¬\u0001J\u0017\u0010\u00ad\u0001\u001a\u00020U2\u0006\u0010a\u001a\u00020\u0017H\u0010¢\u0006\u0003\b®\u0001J.\u0010¯\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020U0\u008c\u00012\u0006\u0010a\u001a\u00020\u00172\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010KH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0014R\u0014\u00106\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0014R\u0014\u00108\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0014R\u0014\u0010:\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0014R\u0011\u0010<\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b=\u0010\u0014R\u0014\u0010>\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0014R\u000e\u0010@\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bC\u0010-R\u0012\u0010D\u001a\u00060ER\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0014R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001f0KX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070M8FX\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006µ\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compositionInvalidations", "", "Landroidx/compose/runtime/ControlledComposition;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "Landroidx/compose/runtime/collection/IdentityArraySet;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "close", "composeInitial", "composition", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final List<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<ControlledComposition> knownCompositions;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private IdentityArraySet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    public Recomposer(CoroutineContext effectCoroutineContext) {
        Intrinsics.checkNotNullParameter(effectCoroutineContext, "effectCoroutineContext");
        this.broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation deriveStateLocked;
                MutableStateFlow mutableStateFlow;
                Throwable th;
                Object lock$iv = Recomposer.this.stateLock;
                Recomposer recomposer = Recomposer.this;
                synchronized (lock$iv) {
                    deriveStateLocked = recomposer.deriveStateLocked();
                    mutableStateFlow = recomposer._state;
                    if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        th = recomposer.closeCause;
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", th);
                    }
                }
                if (deriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    deriveStateLocked.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.stateLock = new Object();
        this.knownCompositions = new ArrayList();
        this.snapshotInvalidations = new IdentityArraySet<>();
        this.compositionInvalidations = new ArrayList();
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        CompletableJob $this$effectJob_u24lambda_u240 = JobKt.Job((Job) effectCoroutineContext.get(Job.INSTANCE));
        $this$effectJob_u24lambda_u240.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable throwable) {
                Job runnerJob;
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                boolean z;
                CancellableContinuation cancellableContinuation;
                Object obj;
                CancellationException cancellation = ExceptionsKt.CancellationException("Recomposer effect job completed", throwable);
                Object continuationToResume = null;
                Object lock$iv = Recomposer.this.stateLock;
                final Recomposer recomposer = Recomposer.this;
                synchronized (lock$iv) {
                    runnerJob = recomposer.runnerJob;
                    if (runnerJob != null) {
                        mutableStateFlow2 = recomposer._state;
                        mutableStateFlow2.setValue(Recomposer.State.ShuttingDown);
                        z = recomposer.isClosed;
                        if (z) {
                            cancellableContinuation = recomposer.workContinuation;
                            if (cancellableContinuation != null) {
                                obj = recomposer.workContinuation;
                                continuationToResume = obj;
                            }
                        } else {
                            runnerJob.cancel(cancellation);
                        }
                        recomposer.workContinuation = null;
                        runnerJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable runnerJobCause) {
                                MutableStateFlow mutableStateFlow3;
                                Object lock$iv2 = Recomposer.this.stateLock;
                                Recomposer recomposer2 = Recomposer.this;
                                Throwable $this$invoke_u24lambda_u243_u24lambda_u242 = throwable;
                                synchronized (lock$iv2) {
                                    if ($this$invoke_u24lambda_u243_u24lambda_u242 == null) {
                                        $this$invoke_u24lambda_u243_u24lambda_u242 = null;
                                    } else if (runnerJobCause != null) {
                                        Throwable it = (runnerJobCause instanceof CancellationException) ^ true ? runnerJobCause : null;
                                        if (it != null) {
                                            kotlin.ExceptionsKt.addSuppressed($this$invoke_u24lambda_u243_u24lambda_u242, it);
                                        }
                                    }
                                    recomposer2.closeCause = $this$invoke_u24lambda_u243_u24lambda_u242;
                                    mutableStateFlow3 = recomposer2._state;
                                    mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        });
                    } else {
                        recomposer.closeCause = cancellation;
                        mutableStateFlow = recomposer._state;
                        mutableStateFlow.setValue(Recomposer.State.ShutDown);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (continuationToResume != null) {
                    Result.Companion companion = Result.INSTANCE;
                    ((Continuation) continuationToResume).resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = $this$effectJob_u24lambda_u240;
        this.effectCoroutineContext = effectCoroutineContext.plus(this.broadcastFrameClock).plus(this.effectJob);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State newState;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations = new IdentityArraySet<>();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            newState = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new IdentityArraySet<>();
            this.compositionInvalidations.clear();
            newState = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else if ((!this.compositionInvalidations.isEmpty()) || this.snapshotInvalidations.isNotEmpty() || (!this.compositionsAwaitingApply.isEmpty()) || (!this.compositionValuesAwaitingInsert.isEmpty()) || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            newState = State.PendingWork;
        } else {
            newState = State.Idle;
        }
        this._state.setValue(newState);
        if (newState != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        Sequence $this$any$iv;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            z = !this.isClosed;
        }
        if (!z) {
            Sequence $this$any$iv2 = this.effectJob.getChildren();
            Iterator<Job> it = $this$any$iv2.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    Job it2 = (Job) element$iv;
                    if (it2.isActive()) {
                        $this$any$iv = 1;
                        break;
                    }
                } else {
                    $this$any$iv = null;
                    break;
                }
            }
            return $this$any$iv != null;
        }
        return true;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        public final void invalidateGroupsWithKey(int key) {
            List $this$fastMapNotNull$iv;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                $this$fastMapNotNull$iv = CollectionsKt.toMutableList((Collection) recomposer.knownCompositions);
            }
            List target$iv = new ArrayList($this$fastMapNotNull$iv.size());
            int size = $this$fastMapNotNull$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = $this$fastMapNotNull$iv.get(index$iv$iv);
                ControlledComposition it = (ControlledComposition) item$iv$iv;
                CompositionImpl compositionImpl = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (compositionImpl != null) {
                    target$iv.add(compositionImpl);
                }
            }
            List $this$fastForEach$iv = target$iv;
            int size2 = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                ((CompositionImpl) item$iv).invalidateGroupsWithKey(key);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List compositions;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                compositions = CollectionsKt.toMutableList((Collection) recomposer.knownCompositions);
            }
            List target$iv = new ArrayList(compositions.size());
            int size = compositions.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = compositions.get(index$iv$iv);
                ControlledComposition it = (ControlledComposition) item$iv$iv;
                CompositionImpl compositionImpl = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (compositionImpl != null) {
                    target$iv.add(compositionImpl);
                }
            }
            List $this$fastMap$iv = target$iv;
            List target$iv2 = new ArrayList($this$fastMap$iv.size());
            int size2 = $this$fastMap$iv.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                Object item$iv$iv2 = $this$fastMap$iv.get(index$iv$iv2);
                HotReloadable $this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246 = new HotReloadable((CompositionImpl) item$iv$iv2);
                $this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246.clearContent();
                target$iv2.add($this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246);
            }
            return target$iv2;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            this.composition = composition;
            this.composable = this.composition.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m2560getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean recoverable, Exception cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.recoverable = recoverable;
            this.cause = cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Exception getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List compositions;
        boolean hasFrameWorkLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            IdentityArraySet changes = this.snapshotInvalidations;
            this.snapshotInvalidations = new IdentityArraySet<>();
            Object lock$iv2 = this.stateLock;
            synchronized (lock$iv2) {
                compositions = CollectionsKt.toMutableList((Collection) this.knownCompositions);
            }
            try {
                Recomposer $this$recordComposerModifications_u24lambda_u249 = this;
                int size = compositions.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = compositions.get(index$iv);
                    ControlledComposition composition = (ControlledComposition) item$iv;
                    composition.recordModificationsOf(changes);
                    if ($this$recordComposerModifications_u24lambda_u249._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                this.snapshotInvalidations = new IdentityArraySet<>();
                Object lock$iv3 = this.stateLock;
                synchronized (lock$iv3) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll((Collection<? extends Object>) changes);
                    Unit unit = Unit.INSTANCE;
                    throw th;
                }
            }
        }
    }

    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        IdentityArraySet changes = this.snapshotInvalidations;
        if (changes.isNotEmpty()) {
            List $this$fastForEach$iv = this.knownCompositions;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                ControlledComposition composition = (ControlledComposition) item$iv;
                composition.recordModificationsOf(changes);
            }
            this.snapshotInvalidations = new IdentityArraySet();
        }
        List $this$fastForEach$iv2 = this.compositionInvalidations;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            onEachInvalidComposition.invoke(item$iv2);
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            Throwable it = this.closeCause;
            if (it != null) {
                throw it;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception e, ControlledComposition failedInitialComposition, boolean recoverable) {
        Boolean bool = _hotReloadEnabled.get();
        Intrinsics.checkNotNullExpressionValue(bool, "_hotReloadEnabled.get()");
        if (!bool.booleanValue()) {
            throw e;
        }
        if (!(e instanceof ComposeRuntimeError)) {
            Object lock$iv = this.stateLock;
            synchronized (lock$iv) {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new IdentityArraySet<>();
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    List it = this.failedCompositions;
                    if (it == null) {
                        it = new ArrayList();
                        this.failedCompositions = it;
                    }
                    if (!it.contains(failedInitialComposition)) {
                        it.add(failedInitialComposition);
                    }
                    this.knownCompositions.remove(failedInitialComposition);
                }
                deriveStateLocked();
            }
            return;
        }
        throw e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState error;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            error = this.errorState;
            if (error != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if (r4 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0082, code lost:
    
        if (r5 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void retryFailedCompositions() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.stateLock
            r1 = 0
            monitor-enter(r0)
            r2 = 0
            java.util.List<androidx.compose.runtime.ControlledComposition> r3 = r9.failedCompositions     // Catch: java.lang.Throwable -> L90
            r4 = r3
            r5 = 0
            r6 = 0
            r9.failedCompositions = r6     // Catch: java.lang.Throwable -> L90
            monitor-exit(r0)
            if (r3 != 0) goto L10
            return
        L10:
            r0 = r3
        L12:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L64
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L64
            r1 = r1 ^ 1
            if (r1 == 0) goto L38
            java.lang.Object r1 = kotlin.collections.CollectionsKt.removeLast(r0)     // Catch: java.lang.Throwable -> L64
            androidx.compose.runtime.ControlledComposition r1 = (androidx.compose.runtime.ControlledComposition) r1     // Catch: java.lang.Throwable -> L64
            boolean r2 = r1 instanceof androidx.compose.runtime.CompositionImpl     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L12
            r1.invalidateAll()     // Catch: java.lang.Throwable -> L64
            r2 = r1
            androidx.compose.runtime.CompositionImpl r2 = (androidx.compose.runtime.CompositionImpl) r2     // Catch: java.lang.Throwable -> L64
            kotlin.jvm.functions.Function2 r2 = r2.getComposable()     // Catch: java.lang.Throwable -> L64
            r1.setContent(r2)     // Catch: java.lang.Throwable -> L64
            androidx.compose.runtime.Recomposer$RecomposerErrorState r2 = r9.errorState     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L12
        L38:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L62
            java.lang.Object r1 = r9.stateLock
            r2 = 0
            monitor-enter(r1)
            r3 = 0
            java.util.List<androidx.compose.runtime.ControlledComposition> r4 = r9.failedCompositions     // Catch: java.lang.Throwable -> L5f
            if (r4 == 0) goto L57
            r5 = r4
            r6 = 0
            r7 = r0
            java.util.Collection r7 = (java.util.Collection) r7     // Catch: java.lang.Throwable -> L5f
            r5.addAll(r7)     // Catch: java.lang.Throwable -> L5f
            if (r4 != 0) goto L58
        L57:
            r4 = r0
        L58:
            r9.failedCompositions = r4     // Catch: java.lang.Throwable -> L5f
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5f
            monitor-exit(r1)
            goto L62
        L5f:
            r3 = move-exception
            monitor-exit(r1)
            throw r3
        L62:
            return
        L64:
            r1 = move-exception
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L8f
            java.lang.Object r2 = r9.stateLock
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            java.util.List<androidx.compose.runtime.ControlledComposition> r5 = r9.failedCompositions     // Catch: java.lang.Throwable -> L8c
            if (r5 == 0) goto L84
            r6 = r5
            r7 = 0
            r8 = r0
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L8c
            r6.addAll(r8)     // Catch: java.lang.Throwable -> L8c
            if (r5 != 0) goto L85
        L84:
            r5 = r0
        L85:
            r9.failedCompositions = r5     // Catch: java.lang.Throwable -> L8c
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L8c
            monitor-exit(r2)
            goto L8f
        L8c:
            r1 = move-exception
            monitor-exit(r2)
            throw r1
        L8f:
            throw r1
        L90:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.retryFailedCompositions():void");
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext recomposeCoroutineContext, Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(recomposeCoroutineContext, this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00ae -> B:12:0x0076). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r9, androidx.compose.runtime.ProduceFrameSignal r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r8, r11)
        L19:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            switch(r2) {
                case 0: goto L64;
                case 1: goto L4c;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2d:
            java.lang.Object r9 = r11.L$4
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r11.L$3
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r11.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r3 = r11.L$1
            androidx.compose.runtime.MonotonicFrameClock r3 = (androidx.compose.runtime.MonotonicFrameClock) r3
            java.lang.Object r4 = r11.L$0
            androidx.compose.runtime.Recomposer r4 = (androidx.compose.runtime.Recomposer) r4
            kotlin.ResultKt.throwOnFailure(r0)
            r7 = r4
            r4 = r9
            r9 = r3
            r3 = r10
            r10 = r2
            r2 = r7
            goto Lb4
        L4c:
            java.lang.Object r9 = r11.L$4
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r11.L$3
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r11.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r3 = r11.L$1
            androidx.compose.runtime.MonotonicFrameClock r3 = (androidx.compose.runtime.MonotonicFrameClock) r3
            java.lang.Object r4 = r11.L$0
            androidx.compose.runtime.Recomposer r4 = (androidx.compose.runtime.Recomposer) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L93
        L64:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L76:
            java.lang.Object r5 = r2.stateLock
            r11.L$0 = r2
            r11.L$1 = r9
            r11.L$2 = r10
            r11.L$3 = r3
            r11.L$4 = r4
            r6 = 1
            r11.label = r6
            java.lang.Object r5 = r10.awaitFrameRequest(r5, r11)
            if (r5 != r1) goto L8d
            return r1
        L8d:
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r2
            r2 = r10
            r10 = r7
        L93:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r5 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r5.<init>()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r11.L$0 = r4
            r11.L$1 = r3
            r11.L$2 = r2
            r11.L$3 = r10
            r11.L$4 = r9
            r6 = 2
            r11.label = r6
            java.lang.Object r5 = r3.withFrameNanos(r5, r11)
            if (r5 != r1) goto Lae
            return r1
        Lae:
            r7 = r4
            r4 = r9
            r9 = r3
            r3 = r10
            r10 = r2
            r2 = r7
        Lb4:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            z = true;
            if (!this.snapshotInvalidations.isNotEmpty() && !(!this.compositionInvalidations.isEmpty())) {
                if (!getHasBroadcastFrameClockAwaitersLocked()) {
                    z = false;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuation;
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl co = cancellable$iv;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = co;
                cancellableContinuation = null;
            } else {
                cancellableContinuation = co;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        MonotonicFrameClock parentFrameClock = MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext());
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, parentFrameClock, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            Object lock$iv = this.stateLock;
            synchronized (lock$iv) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2(null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(content, "content");
        boolean composerWasComposing = composition.isComposing();
        try {
            MutableSnapshot snapshot$iv = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                MutableSnapshot this_$iv$iv = snapshot$iv;
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    if (!composerWasComposing) {
                        Snapshot.INSTANCE.notifyObjectsInitialized();
                    }
                    Object lock$iv = this.stateLock;
                    synchronized (lock$iv) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(composition)) {
                            this.knownCompositions.add(composition);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (!composerWasComposing) {
                                Snapshot.INSTANCE.notifyObjectsInitialized();
                            }
                        } catch (Exception e) {
                            processCompositionError$default(this, e, null, false, 6, null);
                        }
                    } catch (Exception e2) {
                        processCompositionError(e2, composition, true);
                    }
                } finally {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                }
            } finally {
                applyAndCheck(snapshot$iv);
            }
        } catch (Exception e3) {
            processCompositionError(e3, composition, true);
        }
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            List $this$fastAny$iv = this.compositionValuesAwaitingInsert;
            int index$iv$iv = 0;
            int size = $this$fastAny$iv.size();
            while (true) {
                if (index$iv$iv < size) {
                    Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
                    MovableContentStateReference it = (MovableContentStateReference) item$iv$iv;
                    if (Intrinsics.areEqual(it.getComposition(), composition)) {
                        z = true;
                        break;
                    }
                    index$iv$iv++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                Unit unit = Unit.INSTANCE;
                List toInsert = new ArrayList();
                performInitialMovableContentInserts$fillToInsert(toInsert, this, composition);
                while (!toInsert.isEmpty()) {
                    performInsertValues(toInsert, null);
                    performInitialMovableContentInserts$fillToInsert(toInsert, this, composition);
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer this$0, ControlledComposition $composition) {
        list.clear();
        Object lock$iv = this$0.stateLock;
        synchronized (lock$iv) {
            Iterator iterator = this$0.compositionValuesAwaitingInsert.iterator();
            while (iterator.hasNext()) {
                MovableContentStateReference value = iterator.next();
                if (Intrinsics.areEqual(value.getComposition(), $composition)) {
                    list.add(value);
                    iterator.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:33:0x003d, B:18:0x0049, B:19:0x0053), top: B:32:0x003d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.runtime.ControlledComposition performRecompose(final androidx.compose.runtime.ControlledComposition r12, final androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r13) {
        /*
            r11 = this;
            boolean r0 = r12.isComposing()
            r1 = 0
            if (r0 != 0) goto L6f
            boolean r0 = r12.getDisposed()
            if (r0 != 0) goto L6f
            java.util.Set<androidx.compose.runtime.ControlledComposition> r0 = r11.compositionsRemoved
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L1b
            boolean r0 = r0.contains(r12)
            if (r0 != r2) goto L1b
            r0 = r2
            goto L1c
        L1b:
            r0 = r3
        L1c:
            if (r0 == 0) goto L1f
            goto L6f
        L1f:
            r0 = r11
            r4 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE
            kotlin.jvm.functions.Function1 r6 = r0.readObserverOf(r12)
            kotlin.jvm.functions.Function1 r7 = r0.writeObserverOf(r12, r13)
            androidx.compose.runtime.snapshots.MutableSnapshot r5 = r5.takeMutableSnapshot(r6, r7)
            r6 = r5
            androidx.compose.runtime.snapshots.Snapshot r6 = (androidx.compose.runtime.snapshots.Snapshot) r6     // Catch: java.lang.Throwable -> L6a
            r7 = 0
            androidx.compose.runtime.snapshots.Snapshot r8 = r6.makeCurrent()     // Catch: java.lang.Throwable -> L6a
            r9 = 0
            if (r13 == 0) goto L46
            boolean r10 = r13.isNotEmpty()     // Catch: java.lang.Throwable -> L44
            if (r10 != r2) goto L46
            goto L47
        L44:
            r1 = move-exception
            goto L66
        L46:
            r2 = r3
        L47:
            if (r2 == 0) goto L53
            androidx.compose.runtime.Recomposer$performRecompose$1$1 r2 = new androidx.compose.runtime.Recomposer$performRecompose$1$1     // Catch: java.lang.Throwable -> L44
            r2.<init>()     // Catch: java.lang.Throwable -> L44
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch: java.lang.Throwable -> L44
            r12.prepareCompose(r2)     // Catch: java.lang.Throwable -> L44
        L53:
            boolean r2 = r12.recompose()     // Catch: java.lang.Throwable -> L44
            r6.restoreCurrent(r8)     // Catch: java.lang.Throwable -> L6a
            r0.applyAndCheck(r5)
            if (r2 == 0) goto L64
            r1 = r12
            goto L65
        L64:
        L65:
            return r1
        L66:
            r6.restoreCurrent(r8)     // Catch: java.lang.Throwable -> L6a
            throw r1     // Catch: java.lang.Throwable -> L6a
        L6a:
            r1 = move-exception
            r0.applyAndCheck(r5)
            throw r1
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performRecompose(androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.collection.IdentityArraySet):androidx.compose.runtime.ControlledComposition");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fe, code lost:
    
        r4.insertMovableContent(r1);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0106, code lost:
    
        r8.restoreCurrent(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010a, code lost:
    
        applyAndCheck(r7);
        r1 = r29;
        r0 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x012b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0132, code lost:
    
        applyAndCheck(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0135, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r30, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r31) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.compose.runtime.collection.IdentityArraySet):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        ArrayList unusedValues;
        Object lock$iv = this.stateLock;
        int $i$f$synchronized = 0;
        synchronized (lock$iv) {
            int i = 0;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!this.compositionValuesRemoved.isEmpty()) {
                    List references = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                    this.compositionValuesRemoved.clear();
                    ArrayList target$iv = new ArrayList(references.size());
                    int index$iv$iv = 0;
                    int size = references.size();
                    while (index$iv$iv < size) {
                        Object item$iv$iv = references.get(index$iv$iv);
                        MovableContentStateReference it = (MovableContentStateReference) item$iv$iv;
                        int i2 = i;
                        int $i$f$synchronized2 = $i$f$synchronized;
                        target$iv.add(TuplesKt.to(it, this.compositionValueStatesAvailable.get(it)));
                        index$iv$iv++;
                        i = i2;
                        $i$f$synchronized = $i$f$synchronized2;
                    }
                    unusedValues = target$iv;
                    this.compositionValueStatesAvailable.clear();
                } else {
                    unusedValues = CollectionsKt.emptyList();
                }
                List $this$fastForEach$iv = unusedValues;
                int size2 = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size2; index$iv++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    Pair pair = (Pair) item$iv;
                    MovableContentStateReference reference = (MovableContentStateReference) pair.component1();
                    MovableContentState state = (MovableContentState) pair.component2();
                    if (state != null) {
                        reference.getComposition().disposeUnusedMovableContent(state);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ControlledComposition.this.recordReadOf(value);
            }
        };
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final IdentityArraySet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ControlledComposition.this.recordWriteOf(value);
                IdentityArraySet<Object> identityArraySet = modifiedValues;
                if (identityArraySet != null) {
                    identityArraySet.add(value);
                }
            }
        };
    }

    private final <T> T composing(ControlledComposition composition, IdentityArraySet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot snapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot this_$iv = snapshot;
            Snapshot previous$iv = this_$iv.makeCurrent();
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                this_$iv.restoreCurrent(previous$iv);
                InlineMarker.finallyEnd(1);
            }
        } finally {
            InlineMarker.finallyStart(1);
            applyAndCheck(snapshot);
            InlineMarker.finallyEnd(1);
        }
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            SnapshotApplyResult applyResult = snapshot.apply();
            if (applyResult instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            snapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            z = true;
            if (!this.snapshotInvalidations.isNotEmpty() && !(!this.compositionInvalidations.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty())) {
                if (!getHasBroadcastFrameClockAwaitersLocked()) {
                    z = false;
                }
            }
        }
        return z;
    }

    private final boolean getHasFrameWorkLocked() {
        return (this.compositionInvalidations.isEmpty() ^ true) || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || getHasBroadcastFrameClockAwaitersLocked();
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2(null)), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void pauseCompositionFrameClock() {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuation;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
        Intrinsics.checkNotNullParameter(table, "table");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.knownCompositions.remove(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuation;
        Intrinsics.checkNotNullParameter(composition, "composition");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (!this.compositionInvalidations.contains(composition)) {
                this.compositionInvalidations.add(composition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.snapshotInvalidations.add(scope);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.compositionValuesAwaitingInsert.add(reference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(data, "data");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            Set it = this.compositionsRemoved;
            if (it == null) {
                it = new LinkedHashSet();
                this.compositionsRemoved = it;
            }
            it.add(composition);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState remove;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            remove = this.compositionValueStatesAvailable.remove(reference);
        }
        return remove;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet add;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = old.add((PersistentSet) info);
                if (old == add) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(old, add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet remove;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = old.remove((PersistentSet) info);
                if (old == remove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(old, remove));
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$flatMap$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv;
                Iterable list$iv$iv = it.saveStateAndDisposeForHotReload();
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List) destination$iv$iv;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Intrinsics.checkNotNullParameter(token, "token");
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$forEach$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv : $this$forEach$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv;
                it.resetErrorState();
            }
            List holders = (List) token;
            int size = holders.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = holders.get(index$iv);
                HotReloadable it2 = (HotReloadable) item$iv;
                it2.resetContent();
            }
            int size2 = holders.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = holders.get(index$iv2);
                HotReloadable it3 = (HotReloadable) item$iv2;
                it3.recompose();
            }
            Iterable $this$forEach$iv2 = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv2 : $this$forEach$iv2) {
                RecomposerInfoImpl it4 = (RecomposerInfoImpl) element$iv2;
                it4.retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$forEach$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv : $this$forEach$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv;
                RecomposerErrorInfo currentError = it.getCurrentError();
                boolean z = false;
                if (currentError != null && !currentError.getRecoverable()) {
                    z = true;
                }
                if (!z) {
                    it.resetErrorState();
                    it.invalidateGroupsWithKey(key);
                    it.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable $this$mapNotNull$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv$iv;
                RecomposerErrorInfo currentError = it.getCurrentError();
                if (currentError != null) {
                    destination$iv$iv.add(currentError);
                }
            }
            return (List) destination$iv$iv;
        }

        public final void clearErrors$runtime_release() {
            Iterable $this$mapNotNull$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv$iv;
                RecomposerErrorState resetErrorState = it.resetErrorState();
                if (resetErrorState != null) {
                    destination$iv$iv.add(resetErrorState);
                }
            }
        }
    }
}
