package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000í\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b5\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)*\u0001H\b\u0000\u0018\u00002\u00020\u0001:\u0004ð\u0002ñ\u0002Bí\u0001\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012Y\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012Y\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u0010\u0099\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u009a\u0001\u001a\u00020\u0014H\u0002JK\u0010\u009b\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u009c\u0001\"\u0005\b\u0001\u0010\u009d\u00012\b\u0010\u009e\u0001\u001a\u0003H\u009c\u00012\"\u0010\u009f\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u009d\u0001\u0012\u0005\u0012\u0003H\u009c\u0001\u0012\u0004\u0012\u00020\u00140 \u0001¢\u0006\u0003\b¡\u0001H\u0016¢\u0006\u0003\u0010¢\u0001J\t\u0010£\u0001\u001a\u00020\u0005H\u0016J5\u0010¤\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0000\u0010\u009d\u00012\u0007\u0010¥\u0001\u001a\u00020!2\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¦\u0001H\u0087\bø\u0001\u0000¢\u0006\u0003\u0010§\u0001J\u0014\u0010¨\u0001\u001a\u00020!2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0017J\u0012\u0010¨\u0001\u001a\u00020!2\u0007\u0010\u009e\u0001\u001a\u00020!H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030©\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030ª\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030«\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030¬\u0001H\u0017J\u0012\u0010¨\u0001\u001a\u00020!2\u0007\u0010\u009e\u0001\u001a\u00020%H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030\u00ad\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030®\u0001H\u0017J\u0014\u0010¯\u0001\u001a\u00020!2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0017J\u000f\u0010°\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\b±\u0001J\t\u0010²\u0001\u001a\u00020\u0014H\u0002J\t\u0010³\u0001\u001a\u00020\u0014H\u0002J\t\u0010´\u0001\u001a\u00020\u0014H\u0016JG\u0010µ\u0001\u001a\u00020\u00142\u001d\u0010¶\u0001\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010·\u00012\u0014\u0010¹\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u00140¦\u0001¢\u0006\u0003\bº\u0001H\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J$\u0010½\u0001\u001a\u00020%2\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010¿\u0001\u001a\u00020%2\u0007\u0010À\u0001\u001a\u00020%H\u0002J(\u0010Á\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0000\u0010\u009d\u00012\u000f\u0010Â\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010Ã\u0001H\u0017¢\u0006\u0003\u0010Ä\u0001J\t\u0010Å\u0001\u001a\u00020\u0014H\u0002J!\u0010Æ\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u009d\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¦\u0001H\u0016J\t\u0010È\u0001\u001a\u00020tH\u0002J\u0012\u0010È\u0001\u001a\u00020t2\u0007\u0010¾\u0001\u001a\u00020%H\u0002J\u0012\u0010É\u0001\u001a\u00020\u00142\u0007\u0010¨\u0001\u001a\u00020!H\u0017J\t\u0010Ê\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ë\u0001\u001a\u00020\u0014H\u0016J\u000f\u0010Ì\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÍ\u0001JF\u0010Î\u0001\u001a\u00020\u00142\u001d\u0010¶\u0001\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010·\u00012\u0016\u0010¹\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010¦\u0001¢\u0006\u0003\bº\u0001H\u0002¢\u0006\u0003\u0010¼\u0001J\u001b\u0010Ï\u0001\u001a\u00020\u00142\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010Ð\u0001\u001a\u00020%H\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010Ò\u0001\u001a\u00020\u00142\u0007\u0010Ó\u0001\u001a\u00020!H\u0002J\t\u0010Ô\u0001\u001a\u00020\u0014H\u0017J\t\u0010Õ\u0001\u001a\u00020\u0014H\u0002J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0017J\t\u0010×\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ø\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ù\u0001\u001a\u00020\u0014H\u0017J\f\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001H\u0017J\t\u0010Ü\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ý\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010Þ\u0001\u001a\u00020\u00142\u0007\u0010ß\u0001\u001a\u00020%H\u0016J\t\u0010à\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010á\u0001\u001a\u00020\u00142\u0007\u0010Ó\u0001\u001a\u00020!2\t\u0010â\u0001\u001a\u0004\u0018\u00010vH\u0002J\u001a\u0010ã\u0001\u001a\u00020\u00142\u0007\u0010ä\u0001\u001a\u00020%2\u0006\u0010a\u001a\u00020!H\u0002J\t\u0010å\u0001\u001a\u00020\u0014H\u0002J\u000e\u0010O\u001a\u00020!H\u0000¢\u0006\u0003\bæ\u0001J\"\u0010ç\u0001\u001a\u00020\u00142\f\u0010\u009e\u0001\u001a\u0007\u0012\u0002\b\u00030è\u00012\t\u0010é\u0001\u001a\u0004\u0018\u00010LH\u0017J*\u0010ê\u0001\u001a\u00020\u00142\u001f\u0010ë\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030î\u0001\u0012\u0007\u0012\u0005\u0018\u00010î\u00010í\u00010ì\u0001H\u0002J*\u0010ï\u0001\u001a\u00020\u00142\u001f\u0010ë\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030î\u0001\u0012\u0007\u0012\u0005\u0018\u00010î\u00010í\u00010ì\u0001H\u0017J\u0012\u0010ð\u0001\u001a\u00020%2\u0007\u0010ñ\u0001\u001a\u00020%H\u0002J8\u0010ò\u0001\u001a\u00020\u00142\u0010\u0010¹\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010L0è\u00012\u0007\u0010ó\u0001\u001a\u00020t2\t\u0010é\u0001\u001a\u0004\u0018\u00010L2\u0007\u0010ô\u0001\u001a\u00020!H\u0002J\u001f\u0010õ\u0001\u001a\u00020L2\t\u0010ö\u0001\u001a\u0004\u0018\u00010L2\t\u0010÷\u0001\u001a\u0004\u0018\u00010LH\u0017J\u000b\u0010ø\u0001\u001a\u0004\u0018\u00010LH\u0001J-\u0010ù\u0001\u001a\u00020%2\u0007\u0010ú\u0001\u001a\u00020%2\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010¿\u0001\u001a\u00020%2\u0007\u0010û\u0001\u001a\u00020%H\u0002J\u000f\u0010ü\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bý\u0001J\u001f\u0010þ\u0001\u001a\u00020\u00142\u000e\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140¦\u0001H\u0000¢\u0006\u0003\bÿ\u0001J\t\u0010\u0080\u0002\u001a\u00020\u0014H\u0002J!\u0010\u0080\u0002\u001a\u00020\u00142\u0010\u0010\u0081\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010L0\u0082\u0002H\u0002¢\u0006\u0003\u0010\u0083\u0002J\t\u0010\u0084\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0085\u0002\u001a\u00020\u00142\t\b\u0002\u0010\u0086\u0002\u001a\u00020!H\u0002J\t\u0010\u0087\u0002\u001a\u00020\u0014H\u0002J.\u0010\u0088\u0002\u001a\u00020!2\u001d\u0010¶\u0001\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010·\u0001H\u0000¢\u0006\u0003\b\u0089\u0002Jv\u0010\u008a\u0002\u001a\u0003H\u008b\u0002\"\u0005\b\u0000\u0010\u008b\u00022\u000b\b\u0002\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010ñ\u0001\u001a\u0004\u0018\u00010%2%\b\u0002\u0010e\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010í\u00010ì\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008b\u00020¦\u0001H\u0002¢\u0006\u0003\u0010\u008e\u0002J\t\u0010\u008f\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0090\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J_\u0010\u0092\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010\u0093\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0094\u0002\u001a\u00020\u00142\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010\u0095\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0096\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0097\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\u0012\u0010\u0098\u0002\u001a\u00020\u00142\u0007\u0010\u0099\u0002\u001a\u00020YH\u0002J_\u0010\u009a\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J$\u0010\u009b\u0002\u001a\u00020\u00142\u0007\u0010\u008c\u0002\u001a\u00020%2\u0007\u0010\u008d\u0002\u001a\u00020%2\u0007\u0010\u009c\u0002\u001a\u00020%H\u0002J\u0012\u0010\u009d\u0002\u001a\u00020\u00142\u0007\u0010\u009e\u0002\u001a\u00020%H\u0002J\u001a\u0010\u009f\u0002\u001a\u00020\u00142\u0006\u0010q\u001a\u00020%2\u0007\u0010\u009c\u0002\u001a\u00020%H\u0002J\u0019\u0010 \u0002\u001a\u00020\u00142\u000e\u0010¡\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140¦\u0001H\u0016J\t\u0010¢\u0002\u001a\u00020\u0014H\u0002J_\u0010£\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002Jj\u0010¤\u0002\u001a\u00020\u00142\t\b\u0002\u0010\u0086\u0002\u001a\u00020!2T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010¥\u0002\u001a\u00020\u0014H\u0002J$\u0010¦\u0002\u001a\u00020\u00142\u0007\u0010§\u0002\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020%2\u0007\u0010©\u0002\u001a\u00020%H\u0002J\u0013\u0010ª\u0002\u001a\u00020\u00142\b\u0010«\u0002\u001a\u00030\u0085\u0001H\u0016J\t\u0010¬\u0002\u001a\u00020\u0014H\u0002J\u001b\u0010\u00ad\u0002\u001a\u00020\u00142\b\u0010®\u0002\u001a\u00030î\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000b\u0010¯\u0002\u001a\u0004\u0018\u00010LH\u0016J\t\u0010°\u0002\u001a\u00020\u0014H\u0002J\u0012\u0010±\u0002\u001a\u00020\u00142\u0007\u0010²\u0002\u001a\u00020%H\u0002J\t\u0010³\u0002\u001a\u00020\u0014H\u0017J\t\u0010´\u0002\u001a\u00020\u0014H\u0002J\t\u0010µ\u0002\u001a\u00020\u0014H\u0002J\t\u0010¶\u0002\u001a\u00020\u0014H\u0017J\u0013\u0010·\u0002\u001a\u00020\u00142\b\u0010·\u0002\u001a\u00030¸\u0002H\u0017J\t\u0010¹\u0002\u001a\u00020\u0014H\u0017J\u001c\u0010º\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\b\u0010·\u0002\u001a\u00030¸\u0002H\u0017JA\u0010»\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010¼\u0002\u001a\u0004\u0018\u00010L2\b\u0010½\u0002\u001a\u00030¾\u00022\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\bÀ\u0002\u0010Á\u0002J\t\u0010Â\u0002\u001a\u00020\u0014H\u0017J\u0012\u0010Ã\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%H\u0002J\u001d\u0010Ã\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010LH\u0002J\u001d\u0010Å\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010LH\u0017J\t\u0010Æ\u0002\u001a\u00020\u0014H\u0016J&\u0010Ç\u0002\u001a\u00020\u00142\u0015\u0010È\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030É\u00020\u0082\u0002H\u0017¢\u0006\u0003\u0010Ê\u0002J\u001d\u0010Ë\u0002\u001a\u00020\u00142\u0007\u0010Ó\u0001\u001a\u00020!2\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010Ì\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%H\u0017J\u0012\u0010Í\u0002\u001a\u00020\u00012\u0007\u0010Â\u0001\u001a\u00020%H\u0017J\u001d\u0010Î\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010LH\u0016J\t\u0010Ï\u0002\u001a\u00020\u0014H\u0016J\t\u0010Ð\u0002\u001a\u00020\u0014H\u0002J#\u0010Ñ\u0002\u001a\u00020!2\u0007\u0010«\u0002\u001a\u00020<2\t\u0010Ò\u0002\u001a\u0004\u0018\u00010LH\u0000¢\u0006\u0003\bÓ\u0002J\u0014\u0010Ô\u0002\u001a\u00020\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0001J(\u0010Õ\u0002\u001a\u00020\u00142\u0007\u0010Ö\u0002\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010L2\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010×\u0002\u001a\u00020\u00142\u0007\u0010Ø\u0002\u001a\u00020%H\u0002J(\u0010Ù\u0002\u001a\u00020\u00142\u0007\u0010Ö\u0002\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010L2\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010Ú\u0002\u001a\u00020\u00142\u0007\u0010Ö\u0002\u001a\u00020%H\u0002J\u001b\u0010Û\u0002\u001a\u00020\u00142\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010\u009c\u0002\u001a\u00020%H\u0002J\u001b\u0010Ü\u0002\u001a\u00020\u00142\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010Ý\u0002\u001a\u00020%H\u0002J\u001b\u0010Þ\u0002\u001a\u00020t2\u0007\u0010ß\u0002\u001a\u00020t2\u0007\u0010à\u0002\u001a\u00020tH\u0002J\u0014\u0010á\u0002\u001a\u00020\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0016J\u0014\u0010â\u0002\u001a\u00020\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0001J\u0012\u0010ã\u0002\u001a\u00020%2\u0007\u0010¾\u0001\u001a\u00020%H\u0002J\t\u0010ä\u0002\u001a\u00020\u0014H\u0016J\t\u0010å\u0002\u001a\u00020\u0014H\u0002J\t\u0010æ\u0002\u001a\u00020\u0014H\u0002J\u000f\u0010ç\u0002\u001a\u00020\u0014H\u0000¢\u0006\u0003\bè\u0002J\u0085\u0001\u0010é\u0002\u001a\u0003H\u008b\u0002\"\u0005\b\u0000\u0010\u008b\u00022Z\u0010ê\u0002\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f2\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008b\u00020¦\u0001H\u0082\b¢\u0006\u0003\u0010ë\u0002J3\u0010ì\u0002\u001a\u0003H\u008b\u0002\"\u0005\b\u0000\u0010\u008b\u00022\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008b\u00020¦\u0001H\u0082\b¢\u0006\u0003\u0010í\u0002J\u0017\u0010î\u0002\u001a\u00020%*\u00030\u0083\u00012\u0007\u0010¾\u0001\u001a\u00020%H\u0002J\u0019\u0010ï\u0002\u001a\u0004\u0018\u00010L*\u00030\u0083\u00012\u0007\u0010ñ\u0001\u001a\u00020%H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'Ra\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R&\u00101\u001a\u00020%2\u0006\u00100\u001a\u00020%8\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010'R\u0014\u00105\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010'R\u0016\u0010;\u001a\u0004\u0018\u00010<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020!8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u00103\u001a\u0004\bA\u0010#Ro\u0010B\u001aW\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0010\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010IR\u0016\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010S\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bT\u0010#R\u0014\u0010U\u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010#R\u000e\u0010W\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000Ra\u0010Z\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_Ra\u0010`\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150KX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010a\u001a\u00020!2\u0006\u00100\u001a\u00020!8\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bb\u00103\u001a\u0004\bc\u0010#R\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020<0KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\b\u0012\u0004\u0012\u00020f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010g\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bh\u0010#R\u001e\u0010i\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010#Ra\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010m\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010nj\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u0001`oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u0004\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020t0\u007fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u0088\u0001\u001a\u0004\u0018\u00010L8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u000f\u0010\u008b\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008d\u0001\u001a\u00020!8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\b\u008e\u0001\u00103\u001a\u0005\b\u008f\u0001\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0096\u0001\u001a\u0004\u0018\u00010L*\u00030\u0083\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006ò\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Ljava/util/List;Ljava/util/List;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Ljava/util/List;", "setDeferredChanges$runtime_release", "(Ljava/util/List;)V", "derivedStateObserver", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "downNodes", "Landroidx/compose/runtime/Stack;", "", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "implicitRootStart", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "insertUpFixups", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "invalidations", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "pendingUps", "previousCount", "previousMoveFrom", "previousMoveTo", "previousRemove", "providerCache", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "sourceInformationEnabled", "startedGroup", "startedGroups", "writer", "writerHasAProvider", "writersReaderDelta", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changedInstance", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endRoot", "endToMarker", "marker", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", "left", "right", "nextSlot", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "realizeDowns", "nodes", "", "([Ljava/lang/Object;)V", "realizeMovement", "realizeOperationLocation", "forParent", "realizeUps", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "record", "change", "recordApplierOperation", "recordDelete", "recordDown", "recordEndGroup", "recordEndRoot", "recordFixup", "recordInsert", "anchor", "recordInsertUpFixup", "recordMoveNode", "count", "recordReaderMoving", "location", "recordRemoveNode", "recordSideEffect", "effect", "recordSlotEditing", "recordSlotEditingOperation", "recordSlotTableOperation", "recordUp", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "registerInsertUpFixup", "releaseMovableGroupAtCurrent", "reference", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "kind", "Landroidx/compose/runtime/GroupKind;", "data", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProviders", "values", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withChanges", "newChanges", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposerImpl implements Composer {
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> deferredChanges;
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    private Stack<Object> downNodes;
    private final IntStack entersStack;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private IntStack groupNodeCountStack;
    private boolean implicitRootStart;
    private Anchor insertAnchor;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertFixups;
    private SlotTable insertTable;
    private final Stack<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertUpFixups;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack;
    private final List<Invalidation> invalidations;
    private boolean isComposing;
    private boolean isDisposed;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private int[] nodeCountOverrides;
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private IntStack nodeIndexStack;
    private final CompositionContext parentContext;
    private PersistentCompositionLocalMap parentProvider;
    private Pending pending;
    private final Stack<Pending> pendingStack;
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;
    private PersistentCompositionLocalMap providerCache;
    private final IntMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private final IntStack providersInvalidStack;
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup;
    private final SlotTable slotTable;
    private boolean sourceInformationEnabled;
    private boolean startedGroup;
    private final IntStack startedGroups;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private int writersReaderDelta;

    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(Applier<?> applier, CompositionContext parentContext, SlotTable slotTable, Set<RememberObserver> abandonSet, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges, ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(slotTable, "slotTable");
        Intrinsics.checkNotNullParameter(abandonSet, "abandonSet");
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(lateChanges, "lateChanges");
        Intrinsics.checkNotNullParameter(composition, "composition");
        this.applier = applier;
        this.parentContext = parentContext;
        this.slotTable = slotTable;
        this.abandonSet = abandonSet;
        this.changes = changes;
        this.lateChanges = lateChanges;
        this.composition = composition;
        this.pendingStack = new Stack<>();
        this.nodeIndexStack = new IntStack();
        this.groupNodeCountStack = new IntStack();
        this.invalidations = new ArrayList();
        this.entersStack = new IntStack();
        this.parentProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        this.providerUpdates = new IntMap<>(0, 1, null);
        this.providersInvalidStack = new IntStack();
        this.reusingGroup = -1;
        this.sourceInformationEnabled = true;
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.ComposerImpl$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                ComposerImpl.this.childrenComposing++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                ComposerImpl composerImpl = ComposerImpl.this;
                composerImpl.childrenComposing--;
            }
        };
        this.invalidateStack = new Stack<>();
        SlotReader it = this.slotTable.openReader();
        it.close();
        this.reader = it;
        this.insertTable = new SlotTable();
        SlotWriter it2 = this.insertTable.openWriter();
        it2.close();
        this.writer = it2;
        SlotTable this_$iv = this.insertTable;
        SlotReader reader$iv = this_$iv.openReader();
        try {
            Anchor anchor = reader$iv.anchor(0);
            reader$iv.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th) {
            reader$iv.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public ControlledComposition getComposition() {
        return this.composition;
    }

    /* renamed from: isComposing$runtime_release, reason: from getter */
    public final boolean getIsComposing() {
        return this.isComposing;
    }

    /* renamed from: isDisposed$runtime_release, reason: from getter */
    public final boolean getIsDisposed() {
        return this.isDisposed;
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    /* renamed from: getInsertTable$runtime_release, reason: from getter */
    public final SlotTable getInsertTable() {
        return this.insertTable;
    }

    public final void setInsertTable$runtime_release(SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "<set-?>");
        this.insertTable = slotTable;
    }

    public final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final void setDeferredChanges$runtime_release(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        this.deferredChanges = list;
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int key) {
        m2561startBaiHCIY(key, null, GroupKind.INSTANCE.m2571getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        m2561startBaiHCIY(-127, null, GroupKind.INSTANCE.m2571getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl scope = getCurrentRecomposeScope$runtime_release();
        if (scope != null && scope.getUsed()) {
            scope.setDefaultsInScope(true);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        if (this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int key, Object dataKey) {
        m2561startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m2571getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        int asInt;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        IntStack intStack = this.providersInvalidStack;
        asInt = ComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation();
        }
        Set it = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.getLocalInspectionTables());
        if (it != null) {
            it.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(it);
        }
        startGroup(this.parentContext.getCompoundHashKey());
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates.clear();
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            this.writer.close();
        }
        this.insertFixups.clear();
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
    }

    public final void changesApplied$runtime_release() {
        createFreshInsertTable();
        this.providerUpdates.clear();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        if (getInserting() || this.reusing || this.providersInvalid) {
            return false;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return (currentRecomposeScope$runtime_release != null && !currentRecomposeScope$runtime_release.getRequiresRecompose()) && !this.forciblyRecompose;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final void dispose$runtime_release() {
        Object token$iv = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.providerUpdates.clear();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(token$iv);
        }
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = true;
            this.forciblyRecompose = true;
            return true;
        }
        return false;
    }

    private final void startGroup(int key) {
        m2561startBaiHCIY(key, null, GroupKind.INSTANCE.m2571getGroupULZAiWs(), null);
    }

    private final void startGroup(int key, Object dataKey) {
        m2561startBaiHCIY(key, dataKey, GroupKind.INSTANCE.m2571getGroupULZAiWs(), null);
    }

    private final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m2561startBaiHCIY(125, null, GroupKind.INSTANCE.m2572getNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m2561startBaiHCIY(125, null, GroupKind.INSTANCE.m2573getReusableNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(final Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        validateNodeExpected();
        boolean value$iv = getInserting();
        if (value$iv) {
            final int insertIndex = this.nodeIndexStack.peek();
            final Anchor groupAnchor = this.writer.anchor(this.writer.getParent());
            this.groupNodeCount++;
            recordFixup(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$createNode$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "applier");
                    Intrinsics.checkNotNullParameter(slots, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    Object node = factory.invoke();
                    slots.updateNode(groupAnchor, node);
                    applier.insertTopDown(insertIndex, node);
                    applier.down(node);
                }
            });
            recordInsertUpFixup(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$createNode$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "applier");
                    Intrinsics.checkNotNullParameter(slots, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    Object nodeToInsert = slots.node(Anchor.this);
                    applier.up();
                    applier.insertBottomUp(insertIndex, nodeToInsert);
                }
            });
            return;
        }
        ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        boolean value$iv = !getInserting();
        if (value$iv) {
            Object node = getNode(this.reader);
            recordDown(node);
            if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
                recordApplierOperation(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$useNode$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        Intrinsics.checkNotNullParameter(applier, "applier");
                        Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                        Object current = applier.getCurrent();
                        Intrinsics.checkNotNull(current, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
                        ((ComposeNodeLifecycleCallback) current).onReuse();
                    }
                });
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int key, Object dataKey) {
        if (this.reader.getGroupKey() == key && !Intrinsics.areEqual(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrent();
            this.reusing = true;
        }
        m2561startBaiHCIY(key, null, GroupKind.INSTANCE.m2571getGroupULZAiWs(), dataKey);
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int marker) {
        if (marker < 0) {
            int writerLocation = -marker;
            SlotWriter writer = this.writer;
            while (true) {
                int parent = writer.getParent();
                if (parent > writerLocation) {
                    end(writer.isNode(parent));
                } else {
                    return;
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter writer2 = this.writer;
                while (getInserting()) {
                    end(writer2.isNode(writer2.getParent()));
                }
            }
            SlotReader reader = this.reader;
            while (true) {
                int parent2 = reader.getParent();
                if (parent2 > marker) {
                    end(reader.isNode(parent2));
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(final V value, final Function2<? super T, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Function3 operation = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$apply$operation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                invoke2(applier, slotWriter, rememberManager);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                Intrinsics.checkNotNullParameter(applier, "applier");
                Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                block.invoke(applier.getCurrent(), value);
            }
        };
        if (!getInserting()) {
            recordApplierOperation(operation);
        } else {
            recordFixup(operation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Object joinKey(Object left, Object right) {
        Object key;
        key = ComposerKt.getKey(this.reader.getGroupObjectKey(), left, right);
        return key == null ? new JoinedKey(left, right) : key;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            Object it = Composer.INSTANCE.getEmpty();
            return it;
        }
        Object it2 = this.reader.next();
        if (!this.reusing) {
            return it2;
        }
        Object it3 = Composer.INSTANCE.getEmpty();
        return it3;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(Object value) {
        if (!Intrinsics.areEqual(nextSlot(), value)) {
            updateValue(value);
            return true;
        }
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changedInstance(Object value) {
        if (nextSlot() != value) {
            updateValue(value);
            return true;
        }
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char value) {
        Object next = nextSlot();
        if (next instanceof Character) {
            char nextPrimitive = ((Character) next).charValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Character.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte value) {
        Object next = nextSlot();
        if (next instanceof Byte) {
            byte nextPrimitive = ((Number) next).byteValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Byte.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short value) {
        Object next = nextSlot();
        if (next instanceof Short) {
            short nextPrimitive = ((Number) next).shortValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Short.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean value) {
        Object next = nextSlot();
        if (next instanceof Boolean) {
            boolean nextPrimitive = ((Boolean) next).booleanValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Boolean.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float value) {
        Object next = nextSlot();
        if (next instanceof Float) {
            float nextPrimitive = ((Number) next).floatValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Float.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long value) {
        Object next = nextSlot();
        if (next instanceof Long) {
            long nextPrimitive = ((Number) next).longValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Long.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double value) {
        Object next = nextSlot();
        if (next instanceof Double) {
            double nextPrimitive = ((Number) next).doubleValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Double.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int value) {
        Object next = nextSlot();
        if (next instanceof Integer) {
            int nextPrimitive = ((Number) next).intValue();
            if (value == nextPrimitive) {
                return false;
            }
        }
        updateValue(Integer.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean invalid, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        T t = (T) nextSlot();
        if (t == Composer.INSTANCE.getEmpty() || invalid) {
            T invoke = block.invoke();
            updateValue(invoke);
            return invoke;
        }
        return t;
    }

    public final void updateValue(final Object value) {
        if (getInserting()) {
            this.writer.update(value);
            if (value instanceof RememberObserver) {
                record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$updateValue$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                        rememberManager.remembering((RememberObserver) value);
                    }
                });
                this.abandonSet.add(value);
                return;
            }
            return;
        }
        final int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (value instanceof RememberObserver) {
            this.abandonSet.add(value);
        }
        recordSlotTableOperation(true, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$updateValue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                invoke2(applier, slotWriter, rememberManager);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(slots, "slots");
                Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                if (value instanceof RememberObserver) {
                    rememberManager.remembering((RememberObserver) value);
                }
                Object previous = slots.set(groupSlotIndex, value);
                if (previous instanceof RememberObserver) {
                    rememberManager.forgetting((RememberObserver) previous);
                } else if (previous instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) previous).release();
                }
            }
        });
    }

    public final void updateCachedValue(Object value) {
        updateValue(value);
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(final Function0<Unit> effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordSideEffect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                invoke2(applier, slotWriter, rememberManager);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                rememberManager.sideEffect(effect);
            }
        });
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap it = this.providerCache;
        if (it != null) {
            return it;
        }
        return currentCompositionLocalScope(this.reader.getParent());
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int group) {
        if (getInserting() && this.writerHasAProvider) {
            int current = this.writer.getParent();
            while (current > 0) {
                if (this.writer.groupKey(current) == 202 && Intrinsics.areEqual(this.writer.groupObjectKey(current), ComposerKt.getCompositionLocalMap())) {
                    Object groupAux = this.writer.groupAux(current);
                    Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap providers = (PersistentCompositionLocalMap) groupAux;
                    this.providerCache = providers;
                    return providers;
                }
                current = this.writer.parent(current);
            }
        }
        if (this.reader.getGroupsSize() > 0) {
            int current2 = group;
            while (current2 > 0) {
                if (this.reader.groupKey(current2) == 202 && Intrinsics.areEqual(this.reader.groupObjectKey(current2), ComposerKt.getCompositionLocalMap())) {
                    PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerUpdates.get(current2);
                    if (persistentCompositionLocalMap == null) {
                        Object groupAux2 = this.reader.groupAux(current2);
                        Intrinsics.checkNotNull(groupAux2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap = (PersistentCompositionLocalMap) groupAux2;
                    }
                    PersistentCompositionLocalMap providers2 = persistentCompositionLocalMap;
                    this.providerCache = providers2;
                    return providers2;
                }
                current2 = this.reader.parent(current2);
            }
        }
        this.providerCache = this.parentProvider;
        return this.parentProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap parentScope, PersistentCompositionLocalMap currentProviders) {
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder2 = parentScope.builder2();
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> it = builder2;
        it.putAll(currentProviders);
        ?? build2 = builder2.build2();
        startGroup(ComposerKt.providerMapsKey, ComposerKt.getProviderMaps());
        changed((Object) build2);
        changed(currentProviders);
        endGroup();
        return build2;
    }

    @Override // androidx.compose.runtime.Composer
    public void startProviders(final ProvidedValue<?>[] values) {
        PersistentCompositionLocalMap providers;
        boolean invalid;
        int asInt;
        Intrinsics.checkNotNullParameter(values, "values");
        final PersistentCompositionLocalMap parentScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        startGroup(ComposerKt.providerValuesKey, ComposerKt.getProviderValues());
        PersistentCompositionLocalMap currentProviders = (PersistentCompositionLocalMap) ActualJvm_jvmKt.invokeComposableForResult(this, new Function2<Composer, Integer, PersistentCompositionLocalMap>() { // from class: androidx.compose.runtime.ComposerImpl$startProviders$currentProviders$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ PersistentCompositionLocalMap invoke(Composer composer, Integer num) {
                return invoke(composer, num.intValue());
            }

            public final PersistentCompositionLocalMap invoke(Composer $composer, int $changed) {
                $composer.startReplaceableGroup(-948105361);
                ComposerKt.sourceInformation($composer, "C1995@73816L42:Composer.kt#9igjgp");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-948105361, $changed, -1, "androidx.compose.runtime.ComposerImpl.startProviders.<anonymous> (Composer.kt:1994)");
                }
                PersistentCompositionLocalMap compositionLocalMapOf = CompositionLocalMapKt.compositionLocalMapOf(values, parentScope, $composer, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return compositionLocalMapOf;
            }
        });
        endGroup();
        if (getInserting()) {
            providers = updateProviderMapGroup(parentScope, currentProviders);
            invalid = false;
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap oldScope = (PersistentCompositionLocalMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap oldValues = (PersistentCompositionLocalMap) groupGet2;
            if (!getSkipping() || !Intrinsics.areEqual(oldValues, currentProviders)) {
                providers = updateProviderMapGroup(parentScope, currentProviders);
                invalid = true ^ Intrinsics.areEqual(providers, oldScope);
            } else {
                skipGroup();
                providers = oldScope;
                invalid = false;
            }
        }
        if (invalid && !getInserting()) {
            this.providerUpdates.set(this.reader.getCurrent(), providers);
        }
        IntStack intStack = this.providersInvalidStack;
        asInt = ComposerKt.asInt(this.providersInvalid);
        intStack.push(asInt);
        this.providersInvalid = invalid;
        this.providerCache = providers;
        m2561startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m2571getGroupULZAiWs(), providers);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProviders() {
        boolean asBool;
        endGroup();
        endGroup();
        asBool = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providersInvalid = asBool;
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> T consume(CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        startGroup(ComposerKt.referenceKey, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        Object nextSlot = nextSlot();
        CompositionContextHolder holder = nextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) nextSlot : null;
        if (holder == null) {
            holder = new CompositionContextHolder(new CompositionContextImpl(getCompoundKeyHash(), this.forceRecomposeScopes));
            updateValue(holder);
        }
        holder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return holder.getRef();
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack it = this.invalidateStack;
        if (this.childrenComposing == 0 && it.isNotEmpty()) {
            return it.peek();
        }
        return null;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            this.writer = this.insertTable.openWriter();
            this.writer.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        this.insertTable = new SlotTable();
        SlotWriter it = this.insertTable.openWriter();
        it.close();
        this.writer = it;
    }

    private final void startReaderGroup(boolean isNode, final Object data) {
        if (isNode) {
            this.reader.startNode();
            return;
        }
        if (data != null && this.reader.getGroupAux() != data) {
            recordSlotTableOperation$default(this, false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$startReaderGroup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(slots, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    slots.updateAux(data);
                }
            }, 1, null);
        }
        this.reader.startGroup();
    }

    /* renamed from: start-BaiHCIY, reason: not valid java name */
    private final void m2561startBaiHCIY(int key, Object objectKey, int kind, Object data) {
        Pending newPending;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(key, objectKey, data);
        boolean isNode = kind != GroupKind.INSTANCE.m2571getGroupULZAiWs();
        if (getInserting()) {
            this.reader.beginEmpty();
            int startIndex = this.writer.getCurrentGroup();
            if (isNode) {
                this.writer.startNode(key, Composer.INSTANCE.getEmpty());
            } else if (data != null) {
                this.writer.startData(key, objectKey == null ? Composer.INSTANCE.getEmpty() : objectKey, data);
            } else {
                this.writer.startGroup(key, objectKey == null ? Composer.INSTANCE.getEmpty() : objectKey);
            }
            Pending pending = this.pending;
            if (pending != null) {
                KeyInfo insertKeyInfo = new KeyInfo(key, -1, insertedGroupVirtualIndex(startIndex), -1, 0);
                pending.registerInsert(insertKeyInfo, this.nodeIndex - pending.getStartIndex());
                pending.recordUsed(insertKeyInfo);
            }
            enterGroup(isNode, null);
            return;
        }
        boolean forceReplace = (kind != GroupKind.INSTANCE.m2572getNodeULZAiWs() ? 1 : 0) == 0 && this.reusing;
        if (this.pending == null) {
            int slotKey = this.reader.getGroupKey();
            if (forceReplace || slotKey != key || !Intrinsics.areEqual(objectKey, this.reader.getGroupObjectKey())) {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            } else {
                startReaderGroup(isNode, data);
            }
        }
        Pending pending2 = this.pending;
        if (pending2 != null) {
            KeyInfo keyInfo = pending2.getNext(key, objectKey);
            if (!forceReplace && keyInfo != null) {
                pending2.recordUsed(keyInfo);
                int location = keyInfo.getLocation();
                this.nodeIndex = pending2.nodePositionOf(keyInfo) + pending2.getStartIndex();
                int relativePosition = pending2.slotPositionOf(keyInfo);
                final int currentRelativePosition = relativePosition - pending2.getGroupIndex();
                pending2.registerMoveSlot(relativePosition, pending2.getGroupIndex());
                recordReaderMoving(location);
                this.reader.reposition(location);
                if (currentRelativePosition > 0) {
                    recordSlotEditingOperation(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$start$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                            invoke2(applier, slotWriter, rememberManager);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                            Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                            Intrinsics.checkNotNullParameter(slots, "slots");
                            Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                            slots.moveGroup(currentRelativePosition);
                        }
                    });
                }
                startReaderGroup(isNode, data);
            } else {
                this.reader.beginEmpty();
                this.inserting = true;
                this.providerCache = null;
                ensureWriter();
                this.writer.beginInsert();
                int startIndex2 = this.writer.getCurrentGroup();
                if (isNode) {
                    this.writer.startNode(key, Composer.INSTANCE.getEmpty());
                } else if (data != null) {
                    this.writer.startData(key, objectKey == null ? Composer.INSTANCE.getEmpty() : objectKey, data);
                } else {
                    this.writer.startGroup(key, objectKey == null ? Composer.INSTANCE.getEmpty() : objectKey);
                }
                this.insertAnchor = this.writer.anchor(startIndex2);
                KeyInfo insertKeyInfo2 = new KeyInfo(key, -1, insertedGroupVirtualIndex(startIndex2), -1, 0);
                pending2.registerInsert(insertKeyInfo2, this.nodeIndex - pending2.getStartIndex());
                pending2.recordUsed(insertKeyInfo2);
                Pending newPending2 = new Pending(new ArrayList(), isNode ? 0 : this.nodeIndex);
                newPending = newPending2;
                enterGroup(isNode, newPending);
            }
        }
        newPending = null;
        enterGroup(isNode, newPending);
    }

    private final void enterGroup(boolean isNode, Pending newPending) {
        this.pendingStack.push(this.pending);
        this.pending = newPending;
        this.nodeIndexStack.push(this.nodeIndex);
        if (isNode) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting) {
        Pending previousPending = this.pendingStack.pop();
        if (previousPending != null && !inserting) {
            previousPending.setGroupIndex(previousPending.getGroupIndex() + 1);
        }
        this.pending = previousPending;
        this.nodeIndex = this.nodeIndexStack.pop() + expectedNodeCount;
        this.groupNodeCount = this.groupNodeCountStack.pop() + expectedNodeCount;
    }

    private final void end(boolean isNode) {
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int expectedNodeCount = this.groupNodeCount;
        Pending pending = this.pending;
        if (pending != null && pending.getKeyInfos().size() > 0) {
            List previous = pending.getKeyInfos();
            List current = pending.getUsed();
            Set usedKeys = ListUtilsKt.fastToSet(current);
            Set placedKeys = new LinkedHashSet();
            int currentIndex = 0;
            int currentEnd = current.size();
            int previousIndex = 0;
            int previousEnd = previous.size();
            int nodeOffset = 0;
            while (previousIndex < previousEnd) {
                KeyInfo previousInfo = previous.get(previousIndex);
                if (!usedKeys.contains(previousInfo)) {
                    int deleteOffset = pending.nodePositionOf(previousInfo);
                    recordRemoveNode(pending.getStartIndex() + deleteOffset, previousInfo.getNodes());
                    pending.updateNodeCount(previousInfo.getLocation(), 0);
                    recordReaderMoving(previousInfo.getLocation());
                    this.reader.reposition(previousInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    List<Invalidation> list = this.invalidations;
                    int location = previousInfo.getLocation();
                    int location2 = previousInfo.getLocation();
                    Set usedKeys2 = usedKeys;
                    SlotReader slotReader = this.reader;
                    int previousEnd2 = previousEnd;
                    int previousEnd3 = previousInfo.getLocation();
                    ComposerKt.removeRange(list, location, location2 + slotReader.groupSize(previousEnd3));
                    previousIndex++;
                    usedKeys = usedKeys2;
                    previousEnd = previousEnd2;
                } else {
                    Set usedKeys3 = usedKeys;
                    int previousEnd4 = previousEnd;
                    if (placedKeys.contains(previousInfo)) {
                        previousIndex++;
                        usedKeys = usedKeys3;
                        previousEnd = previousEnd4;
                    } else if (currentIndex >= currentEnd) {
                        usedKeys = usedKeys3;
                        previousEnd = previousEnd4;
                    } else {
                        KeyInfo currentInfo = current.get(currentIndex);
                        if (currentInfo != previousInfo) {
                            int nodePosition = pending.nodePositionOf(currentInfo);
                            placedKeys.add(currentInfo);
                            if (nodePosition != nodeOffset) {
                                int updatedCount = pending.updatedNodeCountOf(currentInfo);
                                recordMoveNode(pending.getStartIndex() + nodePosition, pending.getStartIndex() + nodeOffset, updatedCount);
                                pending.registerMoveNode(nodePosition, nodeOffset, updatedCount);
                            }
                        } else {
                            previousIndex++;
                        }
                        currentIndex++;
                        nodeOffset += pending.updatedNodeCountOf(currentInfo);
                        usedKeys = usedKeys3;
                        previousEnd = previousEnd4;
                    }
                }
            }
            realizeMovement();
            if (previous.size() > 0) {
                recordReaderMoving(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int removeIndex = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int startSlot = this.reader.getCurrent();
            recordDelete();
            int nodesToRemove = this.reader.skipGroup();
            recordRemoveNode(removeIndex, nodesToRemove);
            ComposerKt.removeRange(this.invalidations, startSlot, this.reader.getCurrent());
        }
        boolean inserting = getInserting();
        if (inserting) {
            if (isNode) {
                registerInsertUpFixup();
                expectedNodeCount = 1;
            }
            this.reader.endEmpty();
            int parentGroup = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int virtualIndex = insertedGroupVirtualIndex(parentGroup);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(virtualIndex, 0);
                    updateNodeCountOverrides(virtualIndex, expectedNodeCount);
                }
            }
        } else {
            if (isNode) {
                recordUp();
            }
            recordEndGroup();
            int parentGroup2 = this.reader.getParent();
            int parentNodeCount = updatedNodeCount(parentGroup2);
            if (expectedNodeCount != parentNodeCount) {
                updateNodeCountOverrides(parentGroup2, expectedNodeCount);
            }
            if (isNode) {
                expectedNodeCount = 1;
            }
            this.reader.endGroup();
            realizeMovement();
        }
        exitGroup(expectedNodeCount, inserting);
    }

    private final void recomposeToGroupEnd() {
        Invalidation firstInRange;
        boolean wasComposing = this.isComposing;
        this.isComposing = true;
        boolean recomposed = false;
        int parent = this.reader.getParent();
        int end = this.reader.groupSize(parent) + parent;
        int recomposeIndex = this.nodeIndex;
        int recomposeCompoundKey = getCompoundKeyHash();
        int oldGroupNodeCount = this.groupNodeCount;
        int oldGroup = parent;
        firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrent(), end);
        while (firstInRange != null) {
            int location = firstInRange.getLocation();
            ComposerKt.removeLocation(this.invalidations, location);
            if (firstInRange.isInvalid()) {
                recomposed = true;
                this.reader.reposition(location);
                int newGroup = this.reader.getCurrent();
                recordUpsAndDowns(oldGroup, newGroup, parent);
                oldGroup = newGroup;
                this.nodeIndex = nodeIndexOf(location, newGroup, parent, recomposeIndex);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(newGroup), parent, recomposeCompoundKey);
                this.providerCache = null;
                firstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
            } else {
                this.invalidateStack.push(firstInRange.getScope());
                firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrent(), end);
        }
        if (recomposed) {
            recordUpsAndDowns(oldGroup, parent, parent);
            this.reader.skipToGroupEnd();
            int parentGroupNodes = updatedNodeCount(parent);
            this.nodeIndex = recomposeIndex + parentGroupNodes;
            this.groupNodeCount = oldGroupNodeCount + parentGroupNodes;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = recomposeCompoundKey;
        this.isComposing = wasComposing;
    }

    private final int insertedGroupVirtualIndex(int index) {
        return (-2) - index;
    }

    private final void updateNodeCountOverrides(int group, int newCount) {
        int currentCount = updatedNodeCount(group);
        if (currentCount != newCount) {
            int delta = newCount - currentCount;
            int current = group;
            int minPending = this.pendingStack.getSize() - 1;
            while (current != -1) {
                int newCurrentNodes = updatedNodeCount(current) + delta;
                updateNodeCount(current, newCurrentNodes);
                int pendingIndex = minPending;
                while (true) {
                    if (-1 < pendingIndex) {
                        Pending pending = this.pendingStack.peek(pendingIndex);
                        if (pending == null || !pending.updateNodeCount(current, newCurrentNodes)) {
                            pendingIndex--;
                        } else {
                            minPending = pendingIndex - 1;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (current < 0) {
                    current = this.reader.getParent();
                } else if (!this.reader.isNode(current)) {
                    current = this.reader.parent(current);
                } else {
                    return;
                }
            }
        }
    }

    private final int nodeIndexOf(int groupLocation, int group, int recomposeGroup, int recomposeIndex) {
        int anchorGroup = this.reader.parent(group);
        while (anchorGroup != recomposeGroup && !this.reader.isNode(anchorGroup)) {
            anchorGroup = this.reader.parent(anchorGroup);
        }
        int index = this.reader.isNode(anchorGroup) ? 0 : recomposeIndex;
        if (anchorGroup == group) {
            return index;
        }
        int current = anchorGroup;
        int nodeIndexLimit = (updatedNodeCount(anchorGroup) - this.reader.nodeCount(group)) + index;
        loop1: while (index < nodeIndexLimit && current != groupLocation) {
            current++;
            while (current < groupLocation) {
                int end = this.reader.groupSize(current) + current;
                if (groupLocation >= end) {
                    index += updatedNodeCount(current);
                    current = end;
                }
            }
            break loop1;
        }
        return index;
    }

    private final int updatedNodeCount(int group) {
        int override;
        Integer num;
        if (group >= 0) {
            int[] nodeCounts = this.nodeCountOverrides;
            return (nodeCounts == null || (override = nodeCounts[group]) < 0) ? this.reader.nodeCount(group) : override;
        }
        HashMap it = this.nodeCountVirtualOverrides;
        if (it == null || (num = it.get(Integer.valueOf(group))) == null) {
            return 0;
        }
        return num.intValue();
    }

    private final void updateNodeCount(int group, int count) {
        if (updatedNodeCount(group) != count) {
            if (group < 0) {
                HashMap virtualCounts = this.nodeCountVirtualOverrides;
                if (virtualCounts == null) {
                    ComposerImpl $this$updateNodeCount_u24lambda_u2414 = this;
                    HashMap newCounts = new HashMap();
                    $this$updateNodeCount_u24lambda_u2414.nodeCountVirtualOverrides = newCounts;
                    virtualCounts = newCounts;
                }
                virtualCounts.put(Integer.valueOf(group), Integer.valueOf(count));
                return;
            }
            int[] nodeCounts = this.nodeCountOverrides;
            if (nodeCounts == null) {
                ComposerImpl $this$updateNodeCount_u24lambda_u2415 = this;
                int[] newCounts2 = new int[$this$updateNodeCount_u24lambda_u2415.reader.getGroupsSize()];
                ArraysKt.fill$default(newCounts2, -1, 0, 0, 6, (Object) null);
                $this$updateNodeCount_u24lambda_u2415.nodeCountOverrides = newCounts2;
                nodeCounts = newCounts2;
            }
            nodeCounts[group] = count;
        }
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int oldGroup, int newGroup, int commonRoot) {
        int nearestCommonRoot;
        SlotReader reader = this.reader;
        nearestCommonRoot = ComposerKt.nearestCommonRootOf(reader, oldGroup, newGroup, commonRoot);
        for (int current = oldGroup; current > 0 && current != nearestCommonRoot; current = reader.parent(current)) {
            if (reader.isNode(current)) {
                recordUp();
            }
        }
        doRecordDownsFor(newGroup, nearestCommonRoot);
    }

    private final void doRecordDownsFor(int group, int nearestCommonRoot) {
        if (group > 0 && group != nearestCommonRoot) {
            doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
            if (this.reader.isNode(group)) {
                recordDown(nodeAt(this.reader, group));
            }
        }
    }

    private final int compoundKeyOf(int group, int recomposeGroup, int recomposeKey) {
        if (group == recomposeGroup) {
            return recomposeKey;
        }
        ComposerImpl $this$compoundKeyOf_u24lambda_u2416 = this;
        int groupKey = $this$compoundKeyOf_u24lambda_u2416.groupCompoundKeyPart($this$compoundKeyOf_u24lambda_u2416.reader, group);
        if (groupKey == 126665345) {
            return groupKey;
        }
        int $this$rol$iv = $this$compoundKeyOf_u24lambda_u2416.compoundKeyOf($this$compoundKeyOf_u24lambda_u2416.reader.parent(group), recomposeGroup, recomposeKey);
        return Integer.rotateLeft($this$rol$iv, 3) ^ groupKey;
    }

    private final int groupCompoundKeyPart(SlotReader $this$groupCompoundKeyPart, int group) {
        Object aux;
        if ($this$groupCompoundKeyPart.hasObjectKey(group)) {
            Object it = $this$groupCompoundKeyPart.groupObjectKey(group);
            if (it != null) {
                return it instanceof Enum ? ((Enum) it).ordinal() : it instanceof MovableContent ? MovableContentKt.movableContentKey : it.hashCode();
            }
            return 0;
        }
        int it2 = $this$groupCompoundKeyPart.groupKey(group);
        if (it2 != 207 || (aux = $this$groupCompoundKeyPart.groupAux(group)) == null) {
            return it2;
        }
        return Intrinsics.areEqual(aux, Composer.INSTANCE.getEmpty()) ? it2 : aux.hashCode();
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl scope, Object instance) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Anchor anchor = scope.getAnchor();
        if (anchor == null) {
            return false;
        }
        SlotTable slotTable = this.reader.getTable();
        int location = anchor.toIndexFor(slotTable);
        if (!this.isComposing || location < this.reader.getCurrent()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, location, scope, instance);
        return true;
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            return this.writer.groupKey(this.writer.getParent());
        }
        return this.reader.groupKey(this.reader.getParent());
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader reader = this.reader;
        int key = reader.getGroupKey();
        Object dataKey = reader.getGroupObjectKey();
        Object aux = reader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(key, dataKey, aux);
        startReaderGroup(reader.isNode(), null);
        recomposeToGroupEnd();
        reader.endGroup();
        updateCompoundKeyWhenWeExitGroup(key, dataKey, aux);
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipToGroupEnd() {
        boolean value$iv = this.groupNodeCount == 0;
        if (value$iv) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null) {
                currentRecomposeScope$runtime_release.scopeSkipped();
            }
            if (this.invalidations.isEmpty()) {
                skipReaderToGroupEnd();
                return;
            } else {
                recomposeToGroupEnd();
                return;
            }
        }
        ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean changed) {
        boolean value$iv = this.groupNodeCount == 0;
        if (value$iv) {
            boolean value$iv2 = getInserting();
            if (!value$iv2) {
                if (!changed) {
                    skipReaderToGroupEnd();
                    return;
                }
                int start = this.reader.getCurrent();
                int end = this.reader.getEnd();
                for (final int group = start; group < end; group++) {
                    if (this.reader.isNode(group)) {
                        final Object node = this.reader.node(group);
                        if (node instanceof ComposeNodeLifecycleCallback) {
                            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                    invoke2(applier, slotWriter, rememberManager);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                    Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                                    Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                                    Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                                    rememberManager.deactivating((ComposeNodeLifecycleCallback) node);
                                }
                            });
                        }
                    }
                    this.reader.forEachData$runtime_release(group, new Function2<Integer, Object, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object p2) {
                            invoke(num.intValue(), p2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final int index, final Object data) {
                            if (data instanceof RememberObserver) {
                                ComposerImpl.this.reader.reposition(group);
                                ComposerImpl.recordSlotTableOperation$default(ComposerImpl.this, false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                        invoke2(applier, slotWriter, rememberManager);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                                        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                                        Intrinsics.checkNotNullParameter(slots, "slots");
                                        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                                        boolean value$iv3 = Intrinsics.areEqual(data, slots.slot(slots.getCurrentGroup(), index));
                                        if (value$iv3) {
                                            rememberManager.forgetting((RememberObserver) data);
                                            slots.set(index, Composer.INSTANCE.getEmpty());
                                        } else {
                                            ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                                            throw new KotlinNothingValueException();
                                        }
                                    }
                                }, 1, null);
                            } else if (data instanceof RecomposeScopeImpl) {
                                ((RecomposeScopeImpl) data).release();
                                ComposerImpl.this.reader.reposition(group);
                                ComposerImpl.recordSlotTableOperation$default(ComposerImpl.this, false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                        invoke2(applier, slotWriter, rememberManager);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                                        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                                        Intrinsics.checkNotNullParameter(slots, "slots");
                                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                                        boolean value$iv3 = Intrinsics.areEqual(data, slots.slot(slots.getCurrentGroup(), index));
                                        if (value$iv3) {
                                            slots.set(index, Composer.INSTANCE.getEmpty());
                                        } else {
                                            ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                                            throw new KotlinNothingValueException();
                                        }
                                    }
                                }, 1, null);
                            }
                        }
                    });
                }
                ComposerKt.removeRange(this.invalidations, start, end);
                this.reader.reposition(start);
                this.reader.skipToGroupEnd();
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup".toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Composer startRestartGroup(int key) {
        m2561startBaiHCIY(key, null, GroupKind.INSTANCE.m2571getGroupULZAiWs(), null);
        addRecomposeScope();
        return this;
    }

    private final void addRecomposeScope() {
        Invalidation invalidation;
        RecomposeScopeImpl newScope;
        if (!getInserting()) {
            invalidation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
            Object slot = this.reader.next();
            if (Intrinsics.areEqual(slot, Composer.INSTANCE.getEmpty())) {
                ControlledComposition composition = getComposition();
                Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
                newScope = new RecomposeScopeImpl((CompositionImpl) composition);
                updateValue(newScope);
            } else {
                Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                newScope = (RecomposeScopeImpl) slot;
            }
            newScope.setRequiresRecompose(invalidation != null);
            this.invalidateStack.push(newScope);
            newScope.start(this.compositionToken);
            return;
        }
        ControlledComposition composition2 = getComposition();
        Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        RecomposeScopeImpl scope = new RecomposeScopeImpl((CompositionImpl) composition2);
        this.invalidateStack.push(scope);
        updateValue(scope);
        scope.start(this.compositionToken);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        final Function1 it;
        RecomposeScopeImpl result = null;
        RecomposeScopeImpl scope = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (scope != null) {
            scope.setRequiresRecompose(false);
        }
        if (scope != null && (it = scope.end(this.compositionToken)) != null) {
            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$endRestartGroup$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    it.invoke(this.getComposition());
                }
            });
        }
        if (scope != null && !scope.getSkipped$runtime_release() && (scope.getUsed() || this.forceRecomposeScopes)) {
            if (scope.getAnchor() == null) {
                if (getInserting()) {
                    anchor = this.writer.anchor(this.writer.getParent());
                } else {
                    anchor = this.reader.anchor(this.reader.getParent());
                }
                scope.setAnchor(anchor);
            }
            scope.setDefaultsInvalid(false);
            result = scope;
        }
        end(false);
        return result;
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContent(MovableContent<?> value, Object parameter) {
        Intrinsics.checkNotNullParameter(value, "value");
        invokeMovableContentLambda(value, currentCompositionLocalScope(), parameter, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeMovableContentLambda(final MovableContent<Object> content, PersistentCompositionLocalMap locals, final Object parameter, boolean force) {
        startMovableGroup(MovableContentKt.movableContentKey, content);
        changed(parameter);
        int savedCompoundKeyHash = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            boolean z = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, null);
            }
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), locals)) {
                z = true;
            }
            boolean providersChanged = z;
            if (providersChanged) {
                this.providerUpdates.set(this.reader.getCurrent(), locals);
            }
            m2561startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m2571getGroupULZAiWs(), locals);
            if (getInserting() && !force) {
                this.writerHasAProvider = true;
                this.providerCache = null;
                Anchor anchor = this.writer.anchor(this.writer.parent(this.writer.getParent()));
                MovableContentStateReference reference = new MovableContentStateReference(content, parameter, getComposition(), this.insertTable, anchor, CollectionsKt.emptyList(), currentCompositionLocalScope());
                this.parentContext.insertMovableContent$runtime_release(reference);
            } else {
                boolean savedProvidersInvalid = this.providersInvalid;
                this.providersInvalid = providersChanged;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C2946@112595L18:Composer.kt#9igjgp");
                        if (($changed & 11) == 2 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(316014703, $changed, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:2946)");
                        }
                        content.getContent().invoke(parameter, $composer, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                this.providersInvalid = savedProvidersInvalid;
            }
        } finally {
            endGroup();
            this.compoundKeyHash = savedCompoundKeyHash;
            endMovableGroup();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        Intrinsics.checkNotNullParameter(references, "references");
        try {
            insertMovableContentGuarded(references);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertMovableContentGuarded$positionToParentOf(SlotWriter slots, Applier<Object> applier, int index) {
        while (!slots.indexInParent(index)) {
            slots.skipToGroupEnd();
            if (slots.isNode(slots.getParent())) {
                applier.up();
            }
            slots.endGroup();
        }
    }

    private static final int insertMovableContentGuarded$currentNodeIndex(SlotWriter slots) {
        int original = slots.getCurrentGroup();
        int current = slots.getParent();
        while (current >= 0 && !slots.isNode(current)) {
            current = slots.parent(current);
        }
        int index = 0;
        int current2 = current + 1;
        while (current2 < original) {
            if (slots.indexInGroup(original, current2)) {
                if (slots.isNode(current2)) {
                    index = 0;
                }
                current2++;
            } else {
                index += slots.isNode(current2) ? 1 : slots.nodeCount(current2);
                current2 += slots.groupSize(current2);
            }
        }
        return index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int insertMovableContentGuarded$positionToInsert(SlotWriter slots, Anchor anchor, Applier<Object> applier) {
        int destination = slots.anchorIndex(anchor);
        ComposerKt.runtimeCheck(slots.getCurrentGroup() < destination);
        insertMovableContentGuarded$positionToParentOf(slots, applier, destination);
        int nodeIndex = insertMovableContentGuarded$currentNodeIndex(slots);
        while (slots.getCurrentGroup() < destination) {
            if (slots.indexInCurrentGroup(destination)) {
                if (slots.isNode()) {
                    applier.down(slots.node(slots.getCurrentGroup()));
                    nodeIndex = 0;
                }
                slots.startGroup();
            } else {
                nodeIndex += slots.skipGroup();
            }
        }
        ComposerKt.runtimeCheck(slots.getCurrentGroup() == destination);
        return nodeIndex;
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3;
        int i;
        int index$iv;
        List newChanges$iv;
        int $i$f$withChanges;
        List offsetChanges;
        int i2;
        Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function32;
        SlotTable slotTable;
        Anchor anchor;
        final List nodesToInsert;
        Anchor anchor2;
        SlotReader savedReader$iv;
        int[] savedCountOverrides$iv;
        List savedChanges$iv;
        SlotTable slotTable2;
        List newChanges$iv2 = this.lateChanges;
        int $i$f$withChanges2 = 0;
        List savedChanges$iv2 = this.changes;
        try {
            this.changes = newChanges$iv2;
            int i3 = 0;
            function3 = ComposerKt.resetSlotsInstance;
            record(function3);
            List $this$fastForEach$iv = references;
            int size = $this$fastForEach$iv.size();
            int index$iv2 = 0;
            while (index$iv2 < size) {
                Object item$iv = $this$fastForEach$iv.get(index$iv2);
                Pair<MovableContentStateReference, MovableContentStateReference> pair = (Pair) item$iv;
                final MovableContentStateReference to = pair.component1();
                final MovableContentStateReference from = pair.component2();
                final Anchor anchor3 = to.getAnchor();
                int location = to.getSlotTable().anchorIndex(anchor3);
                final Ref.IntRef effectiveNodeIndex = new Ref.IntRef();
                realizeUps();
                record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                        int insertMovableContentGuarded$positionToInsert;
                        Intrinsics.checkNotNullParameter(applier, "applier");
                        Intrinsics.checkNotNullParameter(slots, "slots");
                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                        Ref.IntRef intRef = Ref.IntRef.this;
                        insertMovableContentGuarded$positionToInsert = ComposerImpl.insertMovableContentGuarded$positionToInsert(slots, anchor3, applier);
                        intRef.element = insertMovableContentGuarded$positionToInsert;
                    }
                });
                if (from == null) {
                    try {
                        SlotTable toSlotTable = to.getSlotTable();
                        if (Intrinsics.areEqual(toSlotTable, this.insertTable)) {
                            createFreshInsertTable();
                        }
                        final SlotReader reader$iv = to.getSlotTable().openReader();
                        try {
                            reader$iv.reposition(location);
                            this.writersReaderDelta = location;
                            final List offsetChanges2 = new ArrayList();
                            try {
                                i = size;
                                index$iv = index$iv2;
                                try {
                                    recomposeMovableContent$default(this, null, null, null, null, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            ComposerImpl this_$iv = ComposerImpl.this;
                                            List newChanges$iv3 = offsetChanges2;
                                            ComposerImpl this_$iv2 = ComposerImpl.this;
                                            SlotReader slotReader = reader$iv;
                                            MovableContentStateReference movableContentStateReference = to;
                                            List savedChanges$iv3 = this_$iv.changes;
                                            try {
                                                this_$iv.changes = newChanges$iv3;
                                                SlotReader savedReader$iv2 = this_$iv2.reader;
                                                int[] savedCountOverrides$iv2 = this_$iv2.nodeCountOverrides;
                                                this_$iv2.nodeCountOverrides = null;
                                                try {
                                                    this_$iv2.reader = slotReader;
                                                    this_$iv2.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
                                                    Unit unit = Unit.INSTANCE;
                                                    this_$iv2.reader = savedReader$iv2;
                                                    this_$iv2.nodeCountOverrides = savedCountOverrides$iv2;
                                                    Unit unit2 = Unit.INSTANCE;
                                                } catch (Throwable th) {
                                                    this_$iv2.reader = savedReader$iv2;
                                                    this_$iv2.nodeCountOverrides = savedCountOverrides$iv2;
                                                    throw th;
                                                }
                                            } finally {
                                                this_$iv.changes = savedChanges$iv3;
                                            }
                                        }
                                    }, 15, null);
                                    if (!offsetChanges2.isEmpty()) {
                                        try {
                                            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$2
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                                    invoke2(applier, slotWriter, rememberManager);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                                                    Intrinsics.checkNotNullParameter(applier, "applier");
                                                    Intrinsics.checkNotNullParameter(slots, "slots");
                                                    Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                                                    Applier offsetApplier = Ref.IntRef.this.element > 0 ? new OffsetApplier(applier, Ref.IntRef.this.element) : applier;
                                                    List $this$fastForEach$iv2 = offsetChanges2;
                                                    int size2 = $this$fastForEach$iv2.size();
                                                    for (int index$iv3 = 0; index$iv3 < size2; index$iv3++) {
                                                        Object item$iv2 = $this$fastForEach$iv2.get(index$iv3);
                                                        Function3 change = (Function3) item$iv2;
                                                        change.invoke(offsetApplier, slots, rememberManager);
                                                    }
                                                }
                                            });
                                        } catch (Throwable th) {
                                            th = th;
                                            reader$iv.close();
                                            throw th;
                                        }
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    reader$iv.close();
                                    newChanges$iv = newChanges$iv2;
                                    $i$f$withChanges = $i$f$withChanges2;
                                    offsetChanges = $this$fastForEach$iv;
                                    i2 = i3;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        this.changes = savedChanges$iv2;
                        throw th;
                    }
                } else {
                    index$iv = index$iv2;
                    i = size;
                    final MovableContentState resolvedState = this.parentContext.movableContentStateResolve$runtime_release(from);
                    if (resolvedState == null || (slotTable = resolvedState.getSlotTable()) == null) {
                        slotTable = from.getSlotTable();
                    }
                    SlotTable fromTable = slotTable;
                    if (resolvedState == null || (slotTable2 = resolvedState.getSlotTable()) == null || (anchor = slotTable2.anchor(0)) == null) {
                        anchor = from.getAnchor();
                    }
                    Anchor fromAnchor = anchor;
                    nodesToInsert = ComposerKt.collectNodesFrom(fromTable, fromAnchor);
                    if (!nodesToInsert.isEmpty()) {
                        record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                invoke2(applier, slotWriter, rememberManager);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                Intrinsics.checkNotNullParameter(applier, "applier");
                                Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                                Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                                int base = Ref.IntRef.this.element;
                                List $this$fastForEachIndexed$iv = nodesToInsert;
                                int size2 = $this$fastForEachIndexed$iv.size();
                                for (int index$iv3 = 0; index$iv3 < size2; index$iv3++) {
                                    Object item$iv2 = $this$fastForEachIndexed$iv.get(index$iv3);
                                    int i4 = index$iv3;
                                    applier.insertBottomUp(base + i4, item$iv2);
                                    applier.insertTopDown(base + i4, item$iv2);
                                }
                            }
                        });
                        if (Intrinsics.areEqual(to.getSlotTable(), this.slotTable)) {
                            anchor2 = anchor3;
                            int group = this.slotTable.anchorIndex(anchor2);
                            updateNodeCount(group, updatedNodeCount(group) + nodesToInsert.size());
                        } else {
                            anchor2 = anchor3;
                        }
                    } else {
                        anchor2 = anchor3;
                    }
                    record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                            invoke2(applier, slotWriter, rememberManager);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                            Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                            Intrinsics.checkNotNullParameter(slots, "slots");
                            Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                            MovableContentState state = MovableContentState.this;
                            if (state == null && (state = this_$iv.parentContext.movableContentStateResolve$runtime_release(from)) == null) {
                                ComposerKt.composeRuntimeError("Could not resolve state for movable content");
                                throw new KotlinNothingValueException();
                            }
                            List anchors = slots.moveIntoGroupFrom(1, state.getSlotTable(), 2);
                            RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.INSTANCE;
                            ControlledComposition composition = to.getComposition();
                            Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
                            companion.adoptAnchoredScopes$runtime_release(slots, anchors, (RecomposeScopeOwner) composition);
                        }
                    });
                    SlotReader reader$iv2 = fromTable.openReader();
                    try {
                        SlotReader savedReader$iv2 = this.reader;
                        int[] savedCountOverrides$iv2 = this.nodeCountOverrides;
                        newChanges$iv = newChanges$iv2;
                        try {
                            this.nodeCountOverrides = null;
                            $i$f$withChanges = $i$f$withChanges2;
                            try {
                                this.reader = reader$iv2;
                                int newLocation = fromTable.anchorIndex(fromAnchor);
                                i2 = i3;
                                try {
                                    reader$iv2.reposition(newLocation);
                                    this.writersReaderDelta = newLocation;
                                    final List offsetChanges3 = new ArrayList();
                                    List savedChanges$iv3 = this.changes;
                                    offsetChanges = $this$fastForEach$iv;
                                    try {
                                        this.changes = offsetChanges3;
                                        try {
                                            recomposeMovableContent(from.getComposition(), to.getComposition(), Integer.valueOf(reader$iv2.getCurrent()), from.getInvalidations$runtime_release(), new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                    ComposerImpl.this.invokeMovableContentLambda(to.getContent$runtime_release(), to.getLocals(), to.getParameter(), true);
                                                }
                                            });
                                            Unit unit2 = Unit.INSTANCE;
                                            try {
                                                this.changes = savedChanges$iv3;
                                                if (!offsetChanges3.isEmpty()) {
                                                    try {
                                                        record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$2
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                                                invoke2(applier, slotWriter, rememberManager);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                                                                Intrinsics.checkNotNullParameter(applier, "applier");
                                                                Intrinsics.checkNotNullParameter(slots, "slots");
                                                                Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                                                                Applier offsetApplier = Ref.IntRef.this.element > 0 ? new OffsetApplier(applier, Ref.IntRef.this.element) : applier;
                                                                List $this$fastForEach$iv2 = offsetChanges3;
                                                                int size2 = $this$fastForEach$iv2.size();
                                                                for (int index$iv3 = 0; index$iv3 < size2; index$iv3++) {
                                                                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv3);
                                                                    Function3 change = (Function3) item$iv2;
                                                                    change.invoke(offsetApplier, slots, rememberManager);
                                                                }
                                                            }
                                                        });
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        savedReader$iv = savedReader$iv2;
                                                        savedCountOverrides$iv = savedCountOverrides$iv2;
                                                        this.reader = savedReader$iv;
                                                        this.nodeCountOverrides = savedCountOverrides$iv;
                                                        throw th;
                                                    }
                                                }
                                                Unit unit3 = Unit.INSTANCE;
                                                try {
                                                    this.reader = savedReader$iv2;
                                                    this.nodeCountOverrides = savedCountOverrides$iv2;
                                                    Unit unit4 = Unit.INSTANCE;
                                                    try {
                                                        reader$iv2.close();
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        this.changes = savedChanges$iv2;
                                                        throw th;
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    reader$iv2.close();
                                                    throw th;
                                                }
                                            } catch (Throwable th9) {
                                                th = th9;
                                                savedReader$iv = savedReader$iv2;
                                                savedCountOverrides$iv = savedCountOverrides$iv2;
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            savedReader$iv = savedReader$iv2;
                                            savedCountOverrides$iv = savedCountOverrides$iv2;
                                            savedChanges$iv = savedChanges$iv3;
                                            try {
                                                this.changes = savedChanges$iv;
                                                throw th;
                                            } catch (Throwable th11) {
                                                th = th11;
                                                this.reader = savedReader$iv;
                                                this.nodeCountOverrides = savedCountOverrides$iv;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                        savedReader$iv = savedReader$iv2;
                                        savedCountOverrides$iv = savedCountOverrides$iv2;
                                        savedChanges$iv = savedChanges$iv3;
                                    }
                                } catch (Throwable th13) {
                                    th = th13;
                                    savedReader$iv = savedReader$iv2;
                                    savedCountOverrides$iv = savedCountOverrides$iv2;
                                }
                            } catch (Throwable th14) {
                                th = th14;
                                savedReader$iv = savedReader$iv2;
                                savedCountOverrides$iv = savedCountOverrides$iv2;
                            }
                        } catch (Throwable th15) {
                            th = th15;
                        }
                    } catch (Throwable th16) {
                        th = th16;
                    }
                }
                function32 = ComposerKt.skipToGroupEndInstance;
                record(function32);
                index$iv2 = index$iv + 1;
                size = i;
                $i$f$withChanges2 = $i$f$withChanges;
                newChanges$iv2 = newChanges$iv;
                $this$fastForEach$iv = offsetChanges;
                i3 = i2;
            }
            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "applier");
                    Intrinsics.checkNotNullParameter(slots, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    ComposerImpl.insertMovableContentGuarded$positionToParentOf(slots, applier, 0);
                    slots.endGroup();
                }
            });
            this.writersReaderDelta = 0;
            Unit unit5 = Unit.INSTANCE;
            this.changes = savedChanges$iv2;
        } catch (Throwable th17) {
            th = th17;
        }
    }

    private final <R> R withChanges(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> newChanges, Function0<? extends R> block) {
        List savedChanges = this.changes;
        try {
            this.changes = newChanges;
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.changes = savedChanges;
            InlineMarker.finallyEnd(1);
        }
    }

    private final <R> R withReader(SlotReader reader, Function0<? extends R> block) {
        SlotReader savedReader = this.reader;
        int[] savedCountOverrides = this.nodeCountOverrides;
        this.nodeCountOverrides = null;
        try {
            this.reader = reader;
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.reader = savedReader;
            this.nodeCountOverrides = savedCountOverrides;
            InlineMarker.finallyEnd(1);
        }
    }

    static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        return composerImpl.recomposeMovableContent((i & 1) != 0 ? null : controlledComposition, (i & 2) != 0 ? null : controlledComposition2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? CollectionsKt.emptyList() : list, function0);
    }

    private final <R> R recomposeMovableContent(ControlledComposition from, ControlledComposition to, Integer index, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> invalidations, Function0<? extends R> block) {
        R r;
        List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list;
        int i;
        int i2;
        boolean z = this.implicitRootStart;
        boolean z2 = this.isComposing;
        int i3 = this.nodeIndex;
        try {
            this.implicitRootStart = false;
            this.isComposing = true;
            this.nodeIndex = 0;
            List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list2 = invalidations;
            int i4 = 0;
            int i5 = 0;
            int size = list2.size();
            while (i5 < size) {
                Pair<RecomposeScopeImpl, IdentityArraySet<Object>> pair = list2.get(i5);
                RecomposeScopeImpl component1 = pair.component1();
                IdentityArraySet<Object> component2 = pair.component2();
                if (component2 == null) {
                    list = list2;
                    i = i4;
                    i2 = size;
                    tryImminentInvalidation$runtime_release(component1, null);
                } else {
                    Object[] values = component2.getValues();
                    list = list2;
                    int size2 = component2.size();
                    i = i4;
                    int i6 = 0;
                    while (i6 < size2) {
                        int i7 = size2;
                        Object obj = values[i6];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        tryImminentInvalidation$runtime_release(component1, obj);
                        i6++;
                        size2 = i7;
                        size = size;
                    }
                    i2 = size;
                }
                i5++;
                list2 = list;
                i4 = i;
                size = i2;
            }
            if (from != null) {
                try {
                    r = (R) from.delegateInvalidations(to, index != null ? index.intValue() : -1, block);
                    if (r == null) {
                    }
                    this.implicitRootStart = z;
                    this.isComposing = z2;
                    this.nodeIndex = i3;
                    return r;
                } catch (Throwable th) {
                    th = th;
                    this.implicitRootStart = z;
                    this.isComposing = z2;
                    this.nodeIndex = i3;
                    throw th;
                }
            }
            r = block.invoke();
            this.implicitRootStart = z;
            this.isComposing = z2;
            this.nodeIndex = i3;
            return r;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(String sourceInformation) {
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        if (getInserting() && this.sourceInformationEnabled) {
            this.writer.insertAux(sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int key, String sourceInformation) {
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        if (this.sourceInformationEnabled) {
            m2561startBaiHCIY(key, null, GroupKind.INSTANCE.m2571getGroupULZAiWs(), sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (this.sourceInformationEnabled) {
            end(false);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        this.sourceInformationEnabled = false;
    }

    public final void composeContent$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(invalidationsRequested, "invalidationsRequested");
        Intrinsics.checkNotNullParameter(content, "content");
        boolean value$iv = this.changes.isEmpty();
        if (value$iv) {
            doCompose(invalidationsRequested, content);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void prepareCompose$runtime_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean value$iv = !this.isComposing;
        if (value$iv) {
            this.isComposing = true;
            try {
                block.invoke();
                return;
            } finally {
                this.isComposing = false;
            }
        }
        ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
        throw new KotlinNothingValueException();
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested) {
        Intrinsics.checkNotNullParameter(invalidationsRequested, "invalidationsRequested");
        boolean value$iv = this.changes.isEmpty();
        if (value$iv) {
            if (invalidationsRequested.isNotEmpty() || (!this.invalidations.isEmpty()) || this.forciblyRecompose) {
                doCompose(invalidationsRequested, null);
                return !this.changes.isEmpty();
            }
            return false;
        }
        ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Finally extract failed */
    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        boolean value$iv = !this.isComposing;
        if (!value$iv) {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported".toString());
            throw new KotlinNothingValueException();
        }
        Object token$iv = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = SnapshotKt.currentSnapshot().getId();
            this.providerUpdates.clear();
            int size = invalidationsRequested.getSize();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object obj = invalidationsRequested.getKeys()[index$iv];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArraySet set = (IdentityArraySet) invalidationsRequested.getValues()[index$iv];
                RecomposeScopeImpl scope = (RecomposeScopeImpl) obj;
                Anchor anchor = scope.getAnchor();
                if (anchor == null) {
                    return;
                }
                int location = anchor.getLocation();
                this.invalidations.add(new Invalidation(scope, location, set));
            }
            List $this$sortBy$iv = this.invalidations;
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv, new Comparator() { // from class: androidx.compose.runtime.ComposerImpl$doCompose$lambda$38$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Invalidation it = (Invalidation) t;
                        Invalidation it2 = (Invalidation) t2;
                        return ComparisonsKt.compareValues(Integer.valueOf(it.getLocation()), Integer.valueOf(it2.getLocation()));
                    }
                });
            }
            this.nodeIndex = 0;
            this.isComposing = true;
            try {
                startRoot();
                Object savedContent = nextSlot();
                if (savedContent != content && content != null) {
                    updateValue(content);
                }
                DerivedStateObserver observer$iv = this.derivedStateObserver;
                MutableVector observers$iv = SnapshotStateKt.derivedStateObservers();
                try {
                    observers$iv.add(observer$iv);
                    if (content != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, content);
                        endGroup();
                    } else if (!(this.forciblyRecompose || this.providersInvalid) || savedContent == null || Intrinsics.areEqual(savedContent, Composer.INSTANCE.getEmpty())) {
                        skipCurrentGroup();
                    } else {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(savedContent, 2));
                        endGroup();
                    }
                    observers$iv.removeAt(observers$iv.getSize() - 1);
                    endRoot();
                    this.isComposing = false;
                    this.invalidations.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    observers$iv.removeAt(observers$iv.getSize() - 1);
                    throw th;
                }
            } catch (Throwable th2) {
                this.isComposing = false;
                this.invalidations.clear();
                abortRoot();
                throw th2;
            }
        } finally {
            Trace.INSTANCE.endSection(token$iv);
        }
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader $this$node) {
        return $this$node.node($this$node.getParent());
    }

    private final Object nodeAt(SlotReader $this$nodeAt, int index) {
        return $this$nodeAt.node(index);
    }

    private final void validateNodeExpected() {
        boolean value$iv = this.nodeExpected;
        if (value$iv) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void validateNodeNotExpected() {
        boolean value$iv = !this.nodeExpected;
        if (value$iv) {
            return;
        }
        ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
        throw new KotlinNothingValueException();
    }

    private final void record(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        this.changes.add(change);
    }

    private final void recordApplierOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        realizeUps();
        realizeDowns();
        record(change);
    }

    private final void recordSlotEditingOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        realizeOperationLocation$default(this, false, 1, null);
        recordSlotEditing();
        record(change);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void recordSlotTableOperation$default(ComposerImpl composerImpl, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.recordSlotTableOperation(z, function3);
    }

    private final void recordSlotTableOperation(boolean forParent, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        realizeOperationLocation(forParent);
        record(change);
    }

    private final void realizeUps() {
        final int count = this.pendingUps;
        if (count > 0) {
            this.pendingUps = 0;
            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeUps$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "applier");
                    Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    int i = count;
                    for (int i2 = 0; i2 < i; i2++) {
                        applier.up();
                    }
                }
            });
        }
    }

    private final void realizeDowns(final Object[] nodes) {
        record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeDowns$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                invoke2(applier, slotWriter, rememberManager);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                Intrinsics.checkNotNullParameter(applier, "applier");
                Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                int length = nodes.length;
                for (int index = 0; index < length; index++) {
                    applier.down(nodes[index]);
                }
            }
        });
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty()) {
            realizeDowns(this.downNodes.toArray());
            this.downNodes.clear();
        }
    }

    private final void recordDown(Object node) {
        this.downNodes.push(node);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty()) {
            this.downNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerImpl composerImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.realizeOperationLocation(z);
    }

    private final void realizeOperationLocation(boolean forParent) {
        SlotReader slotReader = this.reader;
        int location = forParent ? slotReader.getParent() : slotReader.getCurrent();
        final int distance = location - this.writersReaderDelta;
        boolean value$iv = distance >= 0;
        if (value$iv) {
            if (distance > 0) {
                record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeOperationLocation$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(slots, "slots");
                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                        slots.advanceBy(distance);
                    }
                });
                this.writersReaderDelta = location;
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("Tried to seek backward".toString());
        throw new KotlinNothingValueException();
    }

    private final void recordInsert(final Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            final SlotTable insertTable = this.insertTable;
            recordSlotEditingOperation(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordInsert$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(slots, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    slots.beginInsert();
                    slots.moveFrom(SlotTable.this, anchor.toIndexFor(SlotTable.this), false);
                    slots.endInsert();
                }
            });
            return;
        }
        final List fixups = CollectionsKt.toMutableList((Collection) this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        final SlotTable insertTable2 = this.insertTable;
        recordSlotEditingOperation(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordInsert$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                invoke2(applier, slotWriter, rememberManager);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                Intrinsics.checkNotNullParameter(applier, "applier");
                Intrinsics.checkNotNullParameter(slots, "slots");
                Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                SlotTable this_$iv = SlotTable.this;
                List $this$fastForEach$iv = fixups;
                SlotWriter writer$iv = this_$iv.openWriter();
                try {
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Function3 fixup = (Function3) item$iv;
                        fixup.invoke(applier, writer$iv, rememberManager);
                    }
                    Unit unit = Unit.INSTANCE;
                    writer$iv.close();
                    slots.beginInsert();
                    slots.moveFrom(SlotTable.this, anchor.toIndexFor(SlotTable.this), false);
                    slots.endInsert();
                } catch (Throwable th) {
                    writer$iv.close();
                    throw th;
                }
            }
        });
    }

    private final void recordFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        this.insertFixups.add(change);
    }

    private final void recordInsertUpFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> change) {
        this.insertUpFixups.push(change);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    private final void recordDelete() {
        Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3;
        reportFreeMovableContent(this.reader.getCurrent());
        function3 = ComposerKt.removeCurrentGroupInstance;
        recordSlotEditingOperation(function3);
        this.writersReaderDelta += this.reader.getGroupSize();
    }

    private static final int reportFreeMovableContent$reportGroup(final ComposerImpl this$0, int group, boolean needsNodeDelete, int nodeIndex) {
        List $this$fastMap$iv;
        if (this$0.reader.hasMark(group)) {
            int key = this$0.reader.groupKey(group);
            Object objectKey = this$0.reader.groupObjectKey(group);
            if (key == 126665345 && (objectKey instanceof MovableContent)) {
                MovableContent movableContent = (MovableContent) objectKey;
                Object parameter = this$0.reader.groupGet(group, 0);
                Anchor anchor = this$0.reader.anchor(group);
                int end = group + this$0.reader.groupSize(group);
                $this$fastMap$iv = ComposerKt.filterToRange(this$0.invalidations, group, end);
                List target$iv = new ArrayList($this$fastMap$iv.size());
                int index$iv$iv = 0;
                int size = $this$fastMap$iv.size();
                while (index$iv$iv < size) {
                    Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                    Invalidation it = (Invalidation) item$iv$iv;
                    target$iv.add(TuplesKt.to(it.getScope(), it.getInstances()));
                    index$iv$iv++;
                    $this$fastMap$iv = $this$fastMap$iv;
                }
                List invalidations = target$iv;
                final MovableContentStateReference reference = new MovableContentStateReference(movableContent, parameter, this$0.getComposition(), this$0.slotTable, anchor, invalidations, this$0.currentCompositionLocalScope(group));
                this$0.parentContext.deletedMovableContent$runtime_release(reference);
                this$0.recordSlotEditing();
                this$0.record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$reportFreeMovableContent$reportGroup$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(slots, "slots");
                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                        ComposerImpl.this.releaseMovableGroupAtCurrent(reference, slots);
                    }
                });
                if (needsNodeDelete) {
                    this$0.realizeMovement();
                    this$0.realizeUps();
                    this$0.realizeDowns();
                    int nodeCount = this$0.reader.isNode(group) ? 1 : this$0.reader.nodeCount(group);
                    if (nodeCount > 0) {
                        this$0.recordRemoveNode(nodeIndex, nodeCount);
                    }
                    return 0;
                }
                return this$0.reader.nodeCount(group);
            }
            if (key == 206 && Intrinsics.areEqual(objectKey, ComposerKt.getReference())) {
                Object groupGet = this$0.reader.groupGet(group, 0);
                CompositionContextHolder contextHolder = groupGet instanceof CompositionContextHolder ? (CompositionContextHolder) groupGet : null;
                if (contextHolder != null) {
                    CompositionContextImpl compositionContext = contextHolder.getRef();
                    Iterable $this$forEach$iv = compositionContext.getComposers();
                    for (Object element$iv : $this$forEach$iv) {
                        ComposerImpl composer = (ComposerImpl) element$iv;
                        composer.reportAllMovableContent();
                        this$0.parentContext.reportRemovedComposition$runtime_release(composer.getComposition());
                    }
                }
                return this$0.reader.nodeCount(group);
            }
            return this$0.reader.nodeCount(group);
        }
        if (this$0.reader.containsMark(group)) {
            int size2 = this$0.reader.groupSize(group);
            int end2 = group + size2;
            int current = group + 1;
            int runningNodeCount = 0;
            while (current < end2) {
                boolean isNode = this$0.reader.isNode(current);
                if (isNode) {
                    this$0.realizeMovement();
                    this$0.recordDown(this$0.reader.node(current));
                }
                runningNodeCount += reportFreeMovableContent$reportGroup(this$0, current, isNode || needsNodeDelete, isNode ? 0 : nodeIndex + runningNodeCount);
                if (isNode) {
                    this$0.realizeMovement();
                    this$0.recordUp();
                }
                current += this$0.reader.groupSize(current);
            }
            return runningNodeCount;
        }
        return this$0.reader.nodeCount(group);
    }

    private final void reportFreeMovableContent(int groupBeingRemoved) {
        reportFreeMovableContent$reportGroup(this, groupBeingRemoved, false, 0);
        realizeMovement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseMovableGroupAtCurrent(final MovableContentStateReference reference, SlotWriter slots) {
        SlotTable slotTable = new SlotTable();
        SlotWriter writer$iv = slotTable.openWriter();
        try {
            writer$iv.beginInsert();
            writer$iv.startGroup(MovableContentKt.movableContentKey, reference.getContent$runtime_release());
            SlotWriter.markGroup$default(writer$iv, 0, 1, null);
            writer$iv.update(reference.getParameter());
            List anchors = slots.moveTo(reference.getAnchor(), 1, writer$iv);
            writer$iv.skipGroup();
            writer$iv.endGroup();
            writer$iv.endInsert();
            writer$iv.close();
            MovableContentState state = new MovableContentState(slotTable);
            if (RecomposeScopeImpl.INSTANCE.hasAnchoredRecomposeScopes$runtime_release(slotTable, anchors)) {
                final ControlledComposition composition = getComposition();
                RecomposeScopeOwner recomposeScopeOwner = new RecomposeScopeOwner() { // from class: androidx.compose.runtime.ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1
                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
                        InvalidationResult result;
                        Intrinsics.checkNotNullParameter(scope, "scope");
                        ControlledComposition controlledComposition = ControlledComposition.this;
                        Object it = null;
                        RecomposeScopeOwner recomposeScopeOwner2 = controlledComposition instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition : null;
                        if (recomposeScopeOwner2 == null || (result = recomposeScopeOwner2.invalidate(scope, instance)) == null) {
                            result = InvalidationResult.IGNORED;
                        }
                        if (result == InvalidationResult.IGNORED) {
                            MovableContentStateReference movableContentStateReference = reference;
                            List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> invalidations$runtime_release = movableContentStateReference.getInvalidations$runtime_release();
                            if (instance != null) {
                                IdentityArraySet it2 = new IdentityArraySet();
                                it2.add(it2);
                                it = it2;
                            }
                            movableContentStateReference.setInvalidations$runtime_release(CollectionsKt.plus((Collection<? extends Pair>) invalidations$runtime_release, TuplesKt.to(scope, it)));
                            return InvalidationResult.SCHEDULED;
                        }
                        return result;
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
                        Intrinsics.checkNotNullParameter(scope, "scope");
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recordReadOf(Object value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                    }
                };
                writer$iv = slotTable.openWriter();
                try {
                    RecomposeScopeImpl.INSTANCE.adoptAnchoredScopes$runtime_release(writer$iv, anchors, recomposeScopeOwner);
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            this.parentContext.movableContentStateReleased$runtime_release(reference, state);
        } finally {
        }
    }

    private final void reportAllMovableContent() {
        Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3;
        if (this.slotTable.containsMark()) {
            List changes = new ArrayList();
            this.deferredChanges = changes;
            SlotReader reader$iv = this.slotTable.openReader();
            try {
                this.reader = reader$iv;
                List savedChanges$iv = this.changes;
                try {
                    this.changes = changes;
                    reportFreeMovableContent(0);
                    realizeUps();
                    if (this.startedGroup) {
                        function3 = ComposerKt.skipToGroupEndInstance;
                        record(function3);
                        recordEndRoot();
                    }
                    Unit unit = Unit.INSTANCE;
                    this.changes = savedChanges$iv;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    this.changes = savedChanges$iv;
                    throw th;
                }
            } finally {
                reader$iv.close();
            }
        }
    }

    private final void recordReaderMoving(int location) {
        int distance = this.reader.getCurrent() - this.writersReaderDelta;
        this.writersReaderDelta = location - distance;
    }

    private final void recordSlotEditing() {
        SlotReader reader;
        int location;
        Function3 function3;
        if (this.reader.getGroupsSize() > 0 && this.startedGroups.peekOr(-2) != (location = (reader = this.reader).getParent())) {
            if (!this.startedGroup && this.implicitRootStart) {
                function3 = ComposerKt.startRootGroup;
                recordSlotTableOperation$default(this, false, function3, 1, null);
                this.startedGroup = true;
            }
            if (location > 0) {
                final Anchor anchor = reader.anchor(location);
                this.startedGroups.push(location);
                recordSlotTableOperation$default(this, false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordSlotEditing$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
                        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(slots, "slots");
                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                        slots.ensureStarted(Anchor.this);
                    }
                }, 1, null);
            }
        }
    }

    private final void recordEndGroup() {
        Function3 function3;
        int location = this.reader.getParent();
        int currentStartedGroup = this.startedGroups.peekOr(-1);
        boolean value$iv = currentStartedGroup <= location;
        if (value$iv) {
            if (this.startedGroups.peekOr(-1) == location) {
                this.startedGroups.pop();
                function3 = ComposerKt.endGroupInstance;
                recordSlotTableOperation$default(this, false, function3, 1, null);
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
        throw new KotlinNothingValueException();
    }

    private final void recordEndRoot() {
        Function3 function3;
        if (this.startedGroup) {
            function3 = ComposerKt.endGroupInstance;
            recordSlotTableOperation$default(this, false, function3, 1, null);
            this.startedGroup = false;
        }
    }

    private final void finalizeCompose() {
        realizeUps();
        boolean value$iv = this.pendingStack.isEmpty();
        if (value$iv) {
            boolean value$iv2 = this.startedGroups.isEmpty();
            if (value$iv2) {
                cleanUpCompose();
                return;
            } else {
                ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
                throw new KotlinNothingValueException();
            }
        }
        ComposerKt.composeRuntimeError("Start/end imbalance".toString());
        throw new KotlinNothingValueException();
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    private final void recordRemoveNode(int nodeIndex, int count) {
        if (count > 0) {
            boolean value$iv = nodeIndex >= 0;
            if (!value$iv) {
                Object message$iv = "Invalid remove index " + nodeIndex;
                ComposerKt.composeRuntimeError(message$iv.toString());
                throw new KotlinNothingValueException();
            }
            if (this.previousRemove != nodeIndex) {
                realizeMovement();
                this.previousRemove = nodeIndex;
                this.previousCount = count;
                return;
            }
            this.previousCount += count;
        }
    }

    private final void recordMoveNode(int from, int to, int count) {
        if (count > 0) {
            if (this.previousCount > 0 && this.previousMoveFrom == from - this.previousCount && this.previousMoveTo == to - this.previousCount) {
                this.previousCount += count;
                return;
            }
            realizeMovement();
            this.previousMoveFrom = from;
            this.previousMoveTo = to;
            this.previousCount = count;
        }
    }

    private final void realizeMovement() {
        final int count = this.previousCount;
        this.previousCount = 0;
        if (count > 0) {
            if (this.previousRemove >= 0) {
                final int removeIndex = this.previousRemove;
                this.previousRemove = -1;
                recordApplierOperation(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeMovement$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        Intrinsics.checkNotNullParameter(applier, "applier");
                        Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                        applier.remove(removeIndex, count);
                    }
                });
            } else {
                final int from = this.previousMoveFrom;
                this.previousMoveFrom = -1;
                final int to = this.previousMoveTo;
                this.previousMoveTo = -1;
                recordApplierOperation(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeMovement$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        invoke2(applier, slotWriter, rememberManager);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        Intrinsics.checkNotNullParameter(applier, "applier");
                        Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                        applier.move(from, to, count);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Composer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class CompositionContextHolder implements RememberObserver {
        private final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.ref = ref;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Composer.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020'0+¢\u0006\u0002\b,H\u0010¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\b2J\u0006\u00103\u001a\u00020'J\r\u00104\u001a\u00020'H\u0010¢\u0006\u0002\b5J\r\u0010\u0011\u001a\u00020\u000fH\u0010¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0010¢\u0006\u0002\b>J\u001d\u0010?\u001a\u00020'2\u0006\u00100\u001a\u0002012\u0006\u0010@\u001a\u00020AH\u0010¢\u0006\u0002\bBJ\u0017\u0010C\u001a\u0004\u0018\u00010A2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bDJ\u001b\u0010E\u001a\u00020'2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001e0\nH\u0010¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020JH\u0010¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\bOJ\r\u0010P\u001a\u00020'H\u0010¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020'2\u0006\u0010I\u001a\u00020JH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020'2\u0006\u0010<\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\n\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001a8PX\u0090\u0004¢\u0006\f\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010\u001c¨\u0006W"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "(Landroidx/compose/runtime/ComposerImpl;IZ)V", "getCollectingParameterInformation$runtime_release", "()Z", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();

        /* renamed from: compositionLocalScope$delegate, reason: from kotlin metadata */
        private final MutableState compositionLocalScope;
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        public CompositionContextImpl(int compoundHashKey, boolean collectingParameterInformation) {
            MutableState mutableStateOf$default;
            this.compoundHashKey = compoundHashKey;
            this.collectingParameterInformation = collectingParameterInformation;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), null, 2, null);
            this.compositionLocalScope = mutableStateOf$default;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCompoundHashKey$runtime_release, reason: from getter */
        public int getCompoundHashKey() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* renamed from: getCollectingParameterInformation$runtime_release, reason: from getter */
        public boolean getCollectingParameterInformation() {
            return this.collectingParameterInformation;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set it = this.inspectionTables;
                if (it != null) {
                    for (ComposerImpl composer : this.composers) {
                        for (Set table : it) {
                            table.remove(composer.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            Iterable iterable = this.inspectionTables;
            if (iterable != null) {
                Iterable $this$forEach$iv = iterable;
                for (Object element$iv : $this$forEach$iv) {
                    Set it = (Set) element$iv;
                    it.remove(((ComposerImpl) composer).slotTable);
                }
            }
            Iterable $this$forEach$iv2 = this.composers;
            TypeIntrinsics.asMutableCollection((Collection) $this$forEach$iv2).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.registerComposition$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            Intrinsics.checkNotNullParameter(content, "content");
            ComposerImpl.this.parentContext.composeInitial$runtime_release(composition, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(scope);
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            State $this$getValue$iv = this.compositionLocalScope;
            return (PersistentCompositionLocalMap) $this$getValue$iv.getValue();
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            MutableState $this$setValue$iv = this.compositionLocalScope;
            $this$setValue$iv.setValue(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            setCompositionLocalScope(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
            Intrinsics.checkNotNullParameter(table, "table");
            HashSet hashSet = this.inspectionTables;
            if (hashSet == null) {
                HashSet it = new HashSet();
                this.inspectionTables = it;
                hashSet = it;
            }
            hashSet.add(table);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime_release() {
            ComposerImpl.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            Intrinsics.checkNotNullParameter(data, "data");
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(reference, data);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime_release(composition);
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int groupKey, Object dataKey, Object data) {
        if (dataKey == null) {
            if (data != null && groupKey == 207 && !Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(data.hashCode());
                return;
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(groupKey);
                return;
            }
        }
        if (dataKey instanceof Enum) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) dataKey).ordinal());
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(dataKey.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int keyHash) {
        int $this$rol$iv = getCompoundKeyHash();
        this.compoundKeyHash = Integer.rotateLeft($this$rol$iv, 3) ^ keyHash;
    }

    private final void updateCompoundKeyWhenWeExitGroup(int groupKey, Object dataKey, Object data) {
        if (dataKey == null) {
            if (data != null && groupKey == 207 && !Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
                updateCompoundKeyWhenWeExitGroupKeyHash(data.hashCode());
                return;
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(groupKey);
                return;
            }
        }
        if (dataKey instanceof Enum) {
            updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) dataKey).ordinal());
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(dataKey.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int groupKey) {
        int $this$ror$iv = getCompoundKeyHash() ^ Integer.hashCode(groupKey);
        this.compoundKeyHash = Integer.rotateRight($this$ror$iv, 3);
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    @Override // androidx.compose.runtime.Composer
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return nextSlot();
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object value) {
        updateValue(value);
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.setUsed(true);
    }
}
