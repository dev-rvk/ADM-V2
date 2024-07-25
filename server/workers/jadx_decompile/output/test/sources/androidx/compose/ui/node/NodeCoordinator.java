package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b#\b \u0018\u0000 \u0092\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004\u0092\u0002\u0093\u0002B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020 H\u0002J,\u0010\u0086\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u00002\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J \u0010\u008e\u0001\u001a\u00020Q2\u0006\u0010P\u001a\u00020QH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J*\u0010\u0091\u0001\u001a\u00020\u001a2\b\u0010\u0092\u0001\u001a\u00030\u008a\u00012\u0006\u0010P\u001a\u00020QH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0010\u0010\u0095\u0001\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u0006J\u001c\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u00062\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0004J\u0012\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u009b\u0001\u001a\u00020\u0007H&J\u0018\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u009e\u0001J\"\u0010\u009f\u0001\u001a\u00030\u008a\u00012\u0007\u0010b\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010\u0090\u0001J\u001b\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020 H\u0002J&\u0010£\u0001\u001a\u00020 2\f\u0010¤\u0001\u001a\u0007\u0012\u0002\b\u00030¥\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J&\u0010¨\u0001\u001a\u0004\u0018\u00010w2\f\u0010¤\u0001\u001a\u0007\u0012\u0002\b\u00030¥\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u0014\u0010«\u0001\u001a\u0004\u0018\u00010w2\u0007\u0010¬\u0001\u001a\u00020 H\u0002JF\u0010\u00ad\u0001\u001a\u00020\u00072\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0092\u0001\u001a\u00030\u008a\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b´\u0001\u0010µ\u0001JH\u0010¶\u0001\u001a\u00020\u00072\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0092\u0001\u001a\u00030\u008a\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b·\u0001\u0010µ\u0001J\t\u0010¸\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010¹\u0001\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u0006H\u0096\u0002J\"\u0010º\u0001\u001a\u00020 2\b\u0010\u0092\u0001\u001a\u00030\u008a\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0007\u0010½\u0001\u001a\u00020 J\u001c\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010À\u0001\u001a\u00020\u00032\u0007\u0010\u0089\u0001\u001a\u00020 H\u0016J,\u0010Á\u0001\u001a\u00030\u008a\u00012\u0007\u0010À\u0001\u001a\u00020\u00032\b\u0010Â\u0001\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J#\u0010Å\u0001\u001a\u00030\u008a\u00012\b\u0010Æ\u0001\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÇ\u0001\u0010\u0090\u0001J#\u0010È\u0001\u001a\u00030\u008a\u00012\b\u0010Æ\u0001\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010\u0090\u0001J#\u0010Ê\u0001\u001a\u00030\u008a\u00012\b\u0010\u0092\u0001\u001a\u00030\u008a\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u0090\u0001J\u000f\u0010Ì\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\bÍ\u0001J\t\u0010Î\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010Ï\u0001\u001a\u00020\u0007J\u001b\u0010Ð\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020V2\u0007\u0010Ò\u0001\u001a\u00020VH\u0014J\u0007\u0010Ó\u0001\u001a\u00020\u0007J\u0007\u0010Ô\u0001\u001a\u00020\u0007J\u0007\u0010Õ\u0001\u001a\u00020\u0007J\u0012\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u0006H\u0016J8\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020-2\u0010\b\u0004\u0010Ú\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010$H\u0084\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001JD\u0010Ý\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020a2\u0007\u0010\u0082\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÞ\u0001\u0010ß\u0001JD\u0010à\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020a2\u0007\u0010\u0082\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bá\u0001\u0010ß\u0001JB\u0010â\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020a2\u0007\u0010\u0082\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bã\u0001\u0010ß\u0001J\u001d\u0010ä\u0001\u001a\u00020\u00072\b\u0010\u0088\u0001\u001a\u00030¿\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010å\u0001J,\u0010æ\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020 2\t\b\u0002\u0010ç\u0001\u001a\u00020 H\u0000¢\u0006\u0003\bè\u0001J\u000f\u0010é\u0001\u001a\u00020\u0007H\u0010¢\u0006\u0003\bê\u0001J\u0007\u0010ë\u0001\u001a\u00020 J\"\u0010ì\u0001\u001a\u00030\u008a\u00012\u0007\u0010b\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bí\u0001\u0010\u0090\u0001J\b\u0010î\u0001\u001a\u00030¿\u0001J+\u0010ï\u0001\u001a\u00020\u00072\u0007\u0010À\u0001\u001a\u00020\u00032\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J+\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ö\u0001J+\u0010÷\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010ö\u0001J-\u0010ù\u0001\u001a\u00020\u00072\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\t\b\u0002\u0010ú\u0001\u001a\u00020 J\u0014\u0010û\u0001\u001a\u00020\u00072\t\b\u0002\u0010ü\u0001\u001a\u00020 H\u0002JL\u0010ý\u0001\u001a\u00020\u0007\"\u0007\b\u0000\u0010þ\u0001\u0018\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003Hþ\u00010¥\u00012\u0014\u0010Ú\u0001\u001a\u000f\u0012\u0005\u0012\u0003Hþ\u0001\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J4\u0010ý\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0002\u001a\u00020V2\u0007\u0010¬\u0001\u001a\u00020 2\u0013\u0010Ú\u0001\u001a\u000e\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0003J#\u0010\u0082\u0002\u001a\u00030\u008a\u00012\b\u0010\u0083\u0002\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0084\u0002\u0010\u0090\u0001J+\u0010\u0085\u0002\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u00062\u0013\u0010Ú\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0084\bø\u0001\u0003J\"\u0010\u0086\u0002\u001a\u00020 2\b\u0010\u0092\u0001\u001a\u00030\u008a\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0087\u0002\u0010¼\u0001JN\u0010\u0088\u0002\u001a\u00020\u0007*\u0004\u0018\u00010w2\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0092\u0001\u001a\u00030\u008a\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002JW\u0010\u008b\u0002\u001a\u00020\u0007*\u0004\u0018\u00010w2\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0092\u0001\u001a\u00030\u008a\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 2\u0007\u0010\u008c\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0002\u0010\u008e\u0002JW\u0010\u008f\u0002\u001a\u00020\u0007*\u0004\u0018\u00010w2\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010\u0092\u0001\u001a\u00030\u008a\u00012\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020 2\u0007\u0010³\u0001\u001a\u00020 2\u0007\u0010\u008c\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0090\u0002\u0010\u008e\u0002J\r\u0010\u0091\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u000e\u0010(\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020 @BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u001d\u0010,\u001a\u00020-8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b.\u0010/R\"\u00101\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u000100@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103RD\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\u0019\u0010)\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR&\u0010E\u001a\u0004\u0018\u00010D2\b\u0010)\u001a\u0004\u0018\u00010D@dX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020Q8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bR\u0010/R\u001c\u0010S\u001a\u0010\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020V\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0015R\u0013\u0010Y\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bZ\u0010\u0018R\u0016\u0010[\u001a\u0004\u0018\u00010\\8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0013\u0010_\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b`\u0010\u0018R/\u0010b\u001a\u00020a2\u0006\u0010)\u001a\u00020a@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010f\u001a\u0004\bc\u0010/\"\u0004\bd\u0010eR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020U0h8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u00020p8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bq\u0010/R\u0014\u0010r\u001a\u00020s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0012\u0010v\u001a\u00020wX¦\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001e\u0010\u007f\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R(\u0010\u0082\u0001\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u001c\"\u0006\b\u0084\u0001\u0010\u0085\u0001\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u0094\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeSelf", "placeSelf-f8xVGno", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-f8xVGno", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", "T", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function0<Unit> invalidateParentLayer;
    private boolean isClipping;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator coordinator) {
            LayerPositionalProperties layerPositionalProperties;
            LayerPositionalProperties layerPositionalProperties2;
            LayerPositionalProperties layerPositionalProperties3;
            Intrinsics.checkNotNullParameter(coordinator, "coordinator");
            if (coordinator.isValidOwnerScope()) {
                layerPositionalProperties = coordinator.layerPositionalProperties;
                if (layerPositionalProperties != null) {
                    layerPositionalProperties2 = NodeCoordinator.tmpLayerPositionalProperties;
                    layerPositionalProperties2.copyFrom(layerPositionalProperties);
                    NodeCoordinator.updateLayerParameters$default(coordinator, false, 1, null);
                    layerPositionalProperties3 = NodeCoordinator.tmpLayerPositionalProperties;
                    if (!layerPositionalProperties3.hasSameValuesAs(layerPositionalProperties)) {
                        LayoutNode layoutNode = coordinator.getLayoutNode();
                        LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                        if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                            if (layoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                                LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                            }
                            layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                        }
                        Owner owner = layoutNode.getOwner();
                        if (owner != null) {
                            owner.requestOnPositionedCallback(layoutNode);
                            return;
                        }
                        return;
                    }
                    return;
                }
                NodeCoordinator.updateLayerParameters$default(coordinator, false, 1, null);
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator coordinator) {
            Intrinsics.checkNotNullParameter(coordinator, "coordinator");
            OwnedLayer layer = coordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m3174constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo4396entityTypeOLwlOKw() {
            return NodeKind.m4400constructorimpl(16);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int kind$iv;
            int kind$iv2;
            MutableVector mutableVector;
            Intrinsics.checkNotNullParameter(node, "node");
            int kind$iv3 = NodeKind.m4400constructorimpl(16);
            MutableVector mutableVector2 = null;
            Modifier.Node node2 = node;
            while (node2 != null) {
                int i = 1;
                if (node2 instanceof PointerInputModifierNode) {
                    PointerInputModifierNode it = (PointerInputModifierNode) node2;
                    if (it.interceptOutOfBoundsChildEvents()) {
                        return true;
                    }
                    kind$iv = kind$iv3;
                } else {
                    Modifier.Node this_$iv$iv = node2;
                    Modifier.Node this_$iv$iv2 = (this_$iv$iv.getKindSet() & kind$iv3) != 0 ? 1 : null;
                    if (this_$iv$iv2 == null || !(node2 instanceof DelegatingNode)) {
                        kind$iv = kind$iv3;
                    } else {
                        int count$iv = 0;
                        DelegatingNode this_$iv$iv3 = (DelegatingNode) node2;
                        Modifier.Node node$iv$iv = this_$iv$iv3.getDelegate();
                        while (node$iv$iv != null) {
                            Modifier.Node next$iv = node$iv$iv;
                            if (((next$iv.getKindSet() & kind$iv3) != 0 ? i : 0) == 0) {
                                kind$iv2 = kind$iv3;
                            } else {
                                count$iv++;
                                if (count$iv == i) {
                                    node2 = next$iv;
                                    kind$iv2 = kind$iv3;
                                } else {
                                    if (mutableVector2 != null) {
                                        kind$iv2 = kind$iv3;
                                        mutableVector = mutableVector2;
                                    } else {
                                        kind$iv2 = kind$iv3;
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    mutableVector2 = mutableVector;
                                    Modifier.Node theNode$iv = node2;
                                    if (theNode$iv != null) {
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(theNode$iv);
                                        }
                                        node2 = null;
                                    }
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(next$iv);
                                    }
                                }
                            }
                            node$iv$iv = node$iv$iv.getChild();
                            kind$iv3 = kind$iv2;
                            i = 1;
                        }
                        kind$iv = kind$iv3;
                        if (count$iv == 1) {
                            kind$iv3 = kind$iv;
                        }
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector2);
                kind$iv3 = kind$iv;
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo4395childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m4325hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo4396entityTypeOLwlOKw() {
            return NodeKind.m4400constructorimpl(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            SemanticsConfiguration collapsedSemantics$ui_release = parentLayoutNode.getCollapsedSemantics$ui_release();
            boolean z = false;
            if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI */
        public void mo4395childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m4326hitTestSemanticsM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0003\u0082\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI */
        void mo4395childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer);

        /* renamed from: entityType-OLwlOKw */
        int mo4396entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    protected abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
        invoke2(canvas);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.INSTANCE.m5346getZeronOccac();
        this.invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
                NodeCoordinator wrappedBy = NodeCoordinator.this.getWrappedBy();
                if (wrappedBy != null) {
                    wrappedBy.invalidateLayer();
                }
            }
        };
    }

    /* renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    /* renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Modifier.Node stopNode = getTail();
        if (!includeTail && (stopNode = stopNode.getParent()) == null) {
            return;
        }
        for (Modifier.Node node = headNode(includeTail); node != null && (node.getAggregateChildKindSet() & mask) != 0; node = node.getChild()) {
            if ((node.getKindSet() & mask) != 0) {
                block.invoke(node);
            }
            if (node == stopNode) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ, reason: not valid java name */
    public final /* synthetic */ <T> void m4393visitNodesaLcG6gQ(int type, Function1<? super T, Unit> block) {
        int i;
        boolean includeTail$iv;
        NodeCoordinator this_$iv;
        int i2;
        boolean includeTail$iv2;
        NodeCoordinator this_$iv2;
        int i3;
        boolean includeTail$iv3;
        NodeCoordinator this_$iv3;
        Object obj;
        Function1<? super T, Unit> block2 = block;
        Intrinsics.checkNotNullParameter(block2, "block");
        int i4 = 0;
        boolean includeTail$iv4 = NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(type);
        NodeCoordinator this_$iv4 = this;
        Modifier.Node stopNode$iv = this_$iv4.getTail();
        if (includeTail$iv4 || (stopNode$iv = stopNode$iv.getParent()) != null) {
            Modifier.Node node$iv = this_$iv4.headNode(includeTail$iv4);
            while (node$iv != null && (node$iv.getAggregateChildKindSet() & type) != 0) {
                if ((node$iv.getKindSet() & type) == 0) {
                    i = i4;
                    includeTail$iv = includeTail$iv4;
                    this_$iv = this_$iv4;
                } else {
                    Object it = node$iv;
                    Object stack$iv = null;
                    Object node$iv2 = it;
                    while (node$iv2 != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node$iv2 instanceof Object) {
                            block2.invoke(node$iv2);
                            i2 = i4;
                            includeTail$iv2 = includeTail$iv4;
                            this_$iv2 = this_$iv4;
                        } else {
                            Modifier.Node this_$iv$iv = (Modifier.Node) node$iv2;
                            if (!((this_$iv$iv.getKindSet() & type) != 0) || !(node$iv2 instanceof DelegatingNode)) {
                                i2 = i4;
                                includeTail$iv2 = includeTail$iv4;
                                this_$iv2 = this_$iv4;
                            } else {
                                int count$iv = 0;
                                DelegatingNode this_$iv$iv2 = (DelegatingNode) node$iv2;
                                Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                                while (node$iv$iv != null) {
                                    Modifier.Node next$iv = node$iv$iv;
                                    if (!((next$iv.getKindSet() & type) != 0)) {
                                        i3 = i4;
                                        includeTail$iv3 = includeTail$iv4;
                                        this_$iv3 = this_$iv4;
                                    } else {
                                        count$iv++;
                                        i3 = i4;
                                        if (count$iv == 1) {
                                            node$iv2 = next$iv;
                                            includeTail$iv3 = includeTail$iv4;
                                            this_$iv3 = this_$iv4;
                                        } else {
                                            Object obj2 = (MutableVector) stack$iv;
                                            if (obj2 != null) {
                                                includeTail$iv3 = includeTail$iv4;
                                                this_$iv3 = this_$iv4;
                                                obj = obj2;
                                            } else {
                                                includeTail$iv3 = includeTail$iv4;
                                                this_$iv3 = this_$iv4;
                                                obj = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            stack$iv = obj;
                                            Modifier.Node theNode$iv = (Modifier.Node) node$iv2;
                                            if (theNode$iv != null) {
                                                MutableVector mutableVector = (MutableVector) stack$iv;
                                                if (mutableVector != null) {
                                                    mutableVector.add(theNode$iv);
                                                }
                                                node$iv2 = null;
                                            }
                                            MutableVector mutableVector2 = (MutableVector) stack$iv;
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(next$iv);
                                            }
                                        }
                                    }
                                    node$iv$iv = node$iv$iv.getChild();
                                    i4 = i3;
                                    includeTail$iv4 = includeTail$iv3;
                                    this_$iv4 = this_$iv3;
                                }
                                i2 = i4;
                                includeTail$iv2 = includeTail$iv4;
                                this_$iv2 = this_$iv4;
                                if (count$iv == 1) {
                                    block2 = block;
                                    i4 = i2;
                                    includeTail$iv4 = includeTail$iv2;
                                    this_$iv4 = this_$iv2;
                                }
                            }
                        }
                        node$iv2 = DelegatableNodeKt.pop((MutableVector) stack$iv);
                        block2 = block;
                        i4 = i2;
                        includeTail$iv4 = includeTail$iv2;
                        this_$iv4 = this_$iv2;
                    }
                    i = i4;
                    includeTail$iv = includeTail$iv4;
                    this_$iv = this_$iv4;
                }
                if (node$iv == stopNode$iv) {
                    return;
                }
                node$iv = node$iv.getChild();
                block2 = block;
                i4 = i;
                includeTail$iv4 = includeTail$iv;
                this_$iv4 = this_$iv;
            }
        }
    }

    /* renamed from: hasNode-H91voCI, reason: not valid java name */
    private final boolean m4373hasNodeH91voCI(int type) {
        Modifier.Node headNode = headNode(NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(type));
        return headNode != null && DelegatableNodeKt.m4297has64DMado(headNode, type);
    }

    /* renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m4386headH91voCI(int type) {
        boolean includeTail$iv = NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node stopNode$iv = getTail();
        if (includeTail$iv || (stopNode$iv = stopNode$iv.getParent()) != null) {
            for (Modifier.Node node$iv = headNode(includeTail$iv); node$iv != null && (node$iv.getAggregateChildKindSet() & type) != 0; node$iv = node$iv.getChild()) {
                if ((node$iv.getKindSet() & type) != 0) {
                    Modifier.Node it = node$iv;
                    return it;
                }
                if (node$iv == stopNode$iv) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo4193getSizeYbymL2g() {
        return getMeasuredSize();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo4187placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return !this.released && getLayoutNode().isAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MeasureResult old = this._measureResult;
        if (value != old) {
            this._measureResult = value;
            if (old == null || value.getWidth() != old.getWidth() || value.getHeight() != old.getHeight()) {
                onMeasureResultChanged(value.getWidth(), value.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!value.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual(value.getAlignmentLines(), this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map it = this.oldAlignmentLines;
                if (it == null) {
                    it = new LinkedHashMap();
                    this.oldAlignmentLines = it;
                }
                it.clear();
                it.putAll(value.getAlignmentLines());
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set set = null;
        for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrapped) {
            MeasureResult measureResult = coordinator._measureResult;
            Map alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z = true;
            }
            if (z) {
                if (set == null) {
                    Set set2 = new LinkedHashSet();
                    set = set2;
                }
                set.addAll(alignmentLines.keySet());
            }
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    protected void onMeasureResultChanged(int width, int height) {
        OwnedLayer layer;
        int type$iv;
        NodeCoordinator this_$iv;
        NodeCoordinator this_$iv2;
        OwnedLayer layer2;
        int type$iv2;
        NodeCoordinator this_$iv3;
        OwnedLayer layer3;
        int type$iv3;
        NodeCoordinator this_$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        OwnedLayer layer4 = this.layer;
        if (layer4 != null) {
            layer4.mo4449resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        m4241setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        NodeCoordinator nodeCoordinator2 = null;
        updateLayerParameters(false);
        int type$iv4 = NodeKind.m4400constructorimpl(4);
        NodeCoordinator this_$iv5 = this;
        boolean includeTail$iv$iv = NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(type$iv4);
        Modifier.Node stopNode$iv$iv = this_$iv5.getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent()) != null) {
            Modifier.Node node$iv$iv = this_$iv5.headNode(includeTail$iv$iv);
            while (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet() & type$iv4) != 0) {
                if ((node$iv$iv.getKindSet() & type$iv4) == 0) {
                    layer = layer4;
                    type$iv = type$iv4;
                    this_$iv = this_$iv5;
                    this_$iv2 = nodeCoordinator2;
                } else {
                    Modifier.Node it$iv = node$iv$iv;
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv;
                    while (node != null) {
                        if (node instanceof DrawModifierNode) {
                            DrawModifierNode it = (DrawModifierNode) node;
                            it.onMeasureResultChanged();
                            layer2 = layer4;
                            type$iv2 = type$iv4;
                            this_$iv3 = this_$iv5;
                        } else {
                            Modifier.Node this_$iv$iv$iv = node;
                            if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                layer2 = layer4;
                                type$iv2 = type$iv4;
                                this_$iv3 = this_$iv5;
                            } else {
                                int count$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                    if (!((next$iv$iv.getKindSet() & type$iv4) != 0)) {
                                        layer3 = layer4;
                                        type$iv3 = type$iv4;
                                        this_$iv4 = this_$iv5;
                                    } else {
                                        count$iv$iv2++;
                                        layer3 = layer4;
                                        if (count$iv$iv2 == 1) {
                                            node = next$iv$iv;
                                            type$iv3 = type$iv4;
                                            this_$iv4 = this_$iv5;
                                        } else {
                                            if (mutableVector2 != null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
                                                this_$iv4 = this_$iv5;
                                                mutableVector = mutableVector2;
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
                                                this_$iv4 = this_$iv5;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            MutableVector mutableVector3 = mutableVector;
                                            Modifier.Node theNode$iv$iv = node;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(theNode$iv$iv);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(next$iv$iv);
                                            }
                                            mutableVector2 = mutableVector3;
                                            count$iv$iv2 = count$iv$iv;
                                        }
                                    }
                                    node$iv$iv$iv = node$iv$iv$iv.getChild();
                                    layer4 = layer3;
                                    type$iv4 = type$iv3;
                                    this_$iv5 = this_$iv4;
                                }
                                layer2 = layer4;
                                type$iv2 = type$iv4;
                                this_$iv3 = this_$iv5;
                                if (count$iv$iv2 == 1) {
                                    layer4 = layer2;
                                    type$iv4 = type$iv2;
                                    this_$iv5 = this_$iv3;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        layer4 = layer2;
                        type$iv4 = type$iv2;
                        this_$iv5 = this_$iv3;
                    }
                    layer = layer4;
                    type$iv = type$iv4;
                    this_$iv = this_$iv5;
                    this_$iv2 = null;
                }
                if (node$iv$iv == stopNode$iv$iv) {
                    break;
                }
                node$iv$iv = node$iv$iv.getChild();
                nodeCoordinator2 = this_$iv2;
                layer4 = layer;
                type$iv4 = type$iv;
                this_$iv5 = this_$iv;
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs, reason: not valid java name */
    protected void m4391setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Object] */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        Modifier.Node thisNode;
        NodeChain this_$iv;
        Modifier.Node thisNode2;
        NodeChain this_$iv2;
        int count$iv;
        MutableVector mutableVector;
        int i = 64;
        if (getLayoutNode().getNodes().m4363hasH91voCI$ui_release(NodeKind.m4400constructorimpl(64))) {
            Modifier.Node thisNode3 = getTail();
            Ref.ObjectRef data = new Ref.ObjectRef();
            NodeChain this_$iv3 = getLayoutNode().getNodes();
            Modifier.Node node$iv = this_$iv3.getTail();
            while (node$iv != null) {
                Modifier.Node node = node$iv;
                int kind$iv = (node.getKindSet() & NodeKind.m4400constructorimpl(i)) != 0 ? 1 : 0;
                if (kind$iv != 0) {
                    int m4400constructorimpl = NodeKind.m4400constructorimpl(i);
                    MutableVector mutableVector2 = null;
                    Modifier.Node node2 = node;
                    while (node2 != null) {
                        if (node2 instanceof ParentDataModifierNode) {
                            ParentDataModifierNode it = (ParentDataModifierNode) node2;
                            data.element = it.modifyParentData(getLayoutNode().getDensity(), data.element);
                            thisNode = thisNode3;
                            this_$iv = this_$iv3;
                        } else {
                            Modifier.Node this_$iv$iv = node2;
                            if (!((this_$iv$iv.getKindSet() & m4400constructorimpl) != 0) || !(node2 instanceof DelegatingNode)) {
                                thisNode = thisNode3;
                                this_$iv = this_$iv3;
                            } else {
                                int count$iv2 = 0;
                                DelegatingNode this_$iv$iv2 = (DelegatingNode) node2;
                                Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                                while (node$iv$iv != null) {
                                    Modifier.Node next$iv = node$iv$iv;
                                    if (!((next$iv.getKindSet() & m4400constructorimpl) != 0)) {
                                        thisNode2 = thisNode3;
                                        this_$iv2 = this_$iv3;
                                    } else {
                                        count$iv2++;
                                        thisNode2 = thisNode3;
                                        if (count$iv2 == 1) {
                                            node2 = next$iv;
                                            this_$iv2 = this_$iv3;
                                        } else {
                                            if (mutableVector2 != null) {
                                                count$iv = count$iv2;
                                                this_$iv2 = this_$iv3;
                                                mutableVector = mutableVector2;
                                            } else {
                                                count$iv = count$iv2;
                                                this_$iv2 = this_$iv3;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            mutableVector2 = mutableVector;
                                            Modifier.Node theNode$iv = node2;
                                            if (theNode$iv != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(theNode$iv);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(next$iv);
                                            }
                                            count$iv2 = count$iv;
                                        }
                                    }
                                    node$iv$iv = node$iv$iv.getChild();
                                    thisNode3 = thisNode2;
                                    this_$iv3 = this_$iv2;
                                }
                                thisNode = thisNode3;
                                this_$iv = this_$iv3;
                                if (count$iv2 == 1) {
                                    thisNode3 = thisNode;
                                    this_$iv3 = this_$iv;
                                }
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector2);
                        thisNode3 = thisNode;
                        this_$iv3 = this_$iv;
                    }
                }
                node$iv = node$iv.getParent();
                thisNode3 = thisNode3;
                this_$iv3 = this_$iv3;
                i = 64;
            }
            return data.element;
        }
        return null;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect == null) {
            MutableRect it = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
            this._rectCache = it;
            return it;
        }
        return mutableRect;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release, reason: not valid java name */
    public final long m4384getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    /* renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    protected final Placeable m4389performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m4242setMeasurementConstraintsBRTryo0(constraints);
        return block.invoke();
    }

    public final void onMeasured() {
        Snapshot previous$iv$iv;
        Modifier.Node stopNode$iv$iv;
        int type$iv;
        Snapshot.Companion this_$iv;
        int $i$f$withoutReadObservation;
        NodeCoordinator this_$iv2;
        int i;
        NodeCoordinator this_$iv3;
        int i2;
        int type$iv2;
        int $i$f$withoutReadObservation2;
        int type$iv3;
        int $i$f$withoutReadObservation3;
        MutableVector mutableVector;
        if (!m4373hasNodeH91voCI(NodeKind.m4400constructorimpl(128))) {
            return;
        }
        Snapshot.Companion this_$iv4 = Snapshot.INSTANCE;
        int $i$f$withoutReadObservation4 = 0;
        Snapshot snapshot$iv = this_$iv4.createNonObservableSnapshot();
        try {
            previous$iv$iv = snapshot$iv.makeCurrent();
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                int type$iv4 = NodeKind.m4400constructorimpl(128);
                NodeCoordinator this_$iv5 = this;
                int i3 = 0;
                boolean includeTail$iv$iv = NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(type$iv4);
                if (includeTail$iv$iv) {
                    try {
                        stopNode$iv$iv = this_$iv5.getTail();
                    } catch (Throwable th2) {
                        th = th2;
                        snapshot$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                } else {
                    stopNode$iv$iv = this_$iv5.getTail().getParent();
                    if (stopNode$iv$iv == null) {
                        Unit unit = Unit.INSTANCE;
                        snapshot$iv.restoreCurrent(previous$iv$iv);
                        snapshot$iv.dispose();
                    }
                }
                Modifier.Node node$iv$iv = this_$iv5.headNode(includeTail$iv$iv);
                while (node$iv$iv != null) {
                    if ((node$iv$iv.getAggregateChildKindSet() & type$iv4) != 0) {
                        if ((node$iv$iv.getKindSet() & type$iv4) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            MutableVector mutableVector2 = null;
                            Modifier.Node node = it$iv;
                            while (node != null) {
                                Snapshot.Companion this_$iv6 = this_$iv4;
                                try {
                                    try {
                                        if (node instanceof LayoutAwareModifierNode) {
                                            try {
                                                LayoutAwareModifierNode it = (LayoutAwareModifierNode) node;
                                                this_$iv3 = this_$iv5;
                                                i2 = i3;
                                                it.mo4284onRemeasuredozmzZPI(getMeasuredSize());
                                                type$iv2 = type$iv4;
                                                $i$f$withoutReadObservation2 = $i$f$withoutReadObservation4;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                                throw th;
                                            }
                                        } else {
                                            this_$iv3 = this_$iv5;
                                            i2 = i3;
                                            Modifier.Node this_$iv$iv$iv = node;
                                            int kindSet = this_$iv$iv$iv.getKindSet() & type$iv4;
                                            int i4 = 1;
                                            if ((kindSet != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                                type$iv2 = type$iv4;
                                                $i$f$withoutReadObservation2 = $i$f$withoutReadObservation4;
                                            } else {
                                                int count$iv$iv = 0;
                                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                                Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                                while (node$iv$iv$iv != null) {
                                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                    if (((next$iv$iv.getKindSet() & type$iv4) != 0 ? i4 : 0) != 0) {
                                                        count$iv$iv++;
                                                        if (count$iv$iv == i4) {
                                                            node = next$iv$iv;
                                                            type$iv3 = type$iv4;
                                                            $i$f$withoutReadObservation3 = $i$f$withoutReadObservation4;
                                                        } else {
                                                            if (mutableVector2 == null) {
                                                                type$iv3 = type$iv4;
                                                                $i$f$withoutReadObservation3 = $i$f$withoutReadObservation4;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                type$iv3 = type$iv4;
                                                                $i$f$withoutReadObservation3 = $i$f$withoutReadObservation4;
                                                                mutableVector = mutableVector2;
                                                            }
                                                            Modifier.Node theNode$iv$iv = node;
                                                            if (theNode$iv$iv != null) {
                                                                if (mutableVector != null) {
                                                                    mutableVector.add(theNode$iv$iv);
                                                                }
                                                                node = null;
                                                            }
                                                            if (mutableVector != null) {
                                                                mutableVector.add(next$iv$iv);
                                                            }
                                                            mutableVector2 = mutableVector;
                                                        }
                                                    } else {
                                                        type$iv3 = type$iv4;
                                                        $i$f$withoutReadObservation3 = $i$f$withoutReadObservation4;
                                                    }
                                                    node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                    type$iv4 = type$iv3;
                                                    $i$f$withoutReadObservation4 = $i$f$withoutReadObservation3;
                                                    i4 = 1;
                                                }
                                                type$iv2 = type$iv4;
                                                $i$f$withoutReadObservation2 = $i$f$withoutReadObservation4;
                                                if (count$iv$iv == 1) {
                                                    this_$iv4 = this_$iv6;
                                                    this_$iv5 = this_$iv3;
                                                    i3 = i2;
                                                    type$iv4 = type$iv2;
                                                    $i$f$withoutReadObservation4 = $i$f$withoutReadObservation2;
                                                }
                                            }
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector2);
                                        this_$iv4 = this_$iv6;
                                        this_$iv5 = this_$iv3;
                                        i3 = i2;
                                        type$iv4 = type$iv2;
                                        $i$f$withoutReadObservation4 = $i$f$withoutReadObservation2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        snapshot$iv.restoreCurrent(previous$iv$iv);
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                            type$iv = type$iv4;
                            this_$iv = this_$iv4;
                            $i$f$withoutReadObservation = $i$f$withoutReadObservation4;
                            this_$iv2 = this_$iv5;
                            i = i3;
                        } else {
                            type$iv = type$iv4;
                            this_$iv = this_$iv4;
                            $i$f$withoutReadObservation = $i$f$withoutReadObservation4;
                            this_$iv2 = this_$iv5;
                            i = i3;
                        }
                        if (node$iv$iv == stopNode$iv$iv) {
                            break;
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        this_$iv4 = this_$iv;
                        this_$iv5 = this_$iv2;
                        i3 = i;
                        type$iv4 = type$iv;
                        $i$f$withoutReadObservation4 = $i$f$withoutReadObservation;
                    } else {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                snapshot$iv.restoreCurrent(previous$iv$iv);
                snapshot$iv.dispose();
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            snapshot$iv.dispose();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo4187placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        m4377placeSelff8xVGno(position, zIndex, layerBlock);
    }

    /* renamed from: placeSelf-f8xVGno, reason: not valid java name */
    private final void m4377placeSelff8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        updateLayerBlock$default(this, layerBlock, false, 2, null);
        if (!IntOffset.m5335equalsimpl0(getPosition(), position)) {
            m4391setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer layer = this.layer;
            if (layer != null) {
                layer.mo4448movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
    }

    /* renamed from: placeSelfApparentToRealOffset-f8xVGno, reason: not valid java name */
    public final void m4390placeSelfApparentToRealOffsetf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        long other$iv = getApparentToRealOffset();
        m4377placeSelff8xVGno(IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(position) + IntOffset.m5336getXimpl(other$iv), IntOffset.m5337getYimpl(position) + IntOffset.m5337getYimpl(other$iv)), zIndex, layerBlock);
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.drawLayer(canvas);
            return;
        }
        float x = IntOffset.m5336getXimpl(getPosition());
        float y = IntOffset.m5337getYimpl(getPosition());
        canvas.translate(x, y);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-x, -y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        Modifier.Node head = m4386headH91voCI(NodeKind.m4400constructorimpl(4));
        if (head == null) {
            performDraw(canvas);
        } else {
            LayoutNodeDrawScope drawScope = getLayoutNode().getMDrawScope$ui_release();
            drawScope.m4335drawx_KDEd0$ui_release(canvas, IntSizeKt.m5388toSizeozmzZPI(mo4193getSizeYbymL2g()), this, head);
        }
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public final void onPlaced() {
        int type$iv;
        NodeCoordinator this_$iv;
        int i;
        NodeCoordinator this_$iv2;
        int type$iv2;
        int i2;
        int type$iv3;
        int i3;
        MutableVector mutableVector;
        int type$iv4 = NodeKind.m4400constructorimpl(128);
        NodeCoordinator this_$iv3 = this;
        int i4 = 0;
        boolean includeTail$iv$iv = NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(type$iv4);
        Modifier.Node stopNode$iv$iv = this_$iv3.getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent()) != null) {
            Modifier.Node node$iv$iv = this_$iv3.headNode(includeTail$iv$iv);
            while (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet() & type$iv4) != 0) {
                if ((node$iv$iv.getKindSet() & type$iv4) == 0) {
                    type$iv = type$iv4;
                    this_$iv = this_$iv3;
                    i = i4;
                } else {
                    Modifier.Node it$iv = node$iv$iv;
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv;
                    while (node != null) {
                        if (node instanceof LayoutAwareModifierNode) {
                            LayoutAwareModifierNode it = (LayoutAwareModifierNode) node;
                            this_$iv2 = this_$iv3;
                            it.onPlaced(this);
                            type$iv2 = type$iv4;
                            i2 = i4;
                        } else {
                            this_$iv2 = this_$iv3;
                            Modifier.Node this_$iv$iv$iv = node;
                            int kindSet = this_$iv$iv$iv.getKindSet() & type$iv4;
                            int i5 = 1;
                            if ((kindSet != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                type$iv2 = type$iv4;
                                i2 = i4;
                            } else {
                                int count$iv$iv = 0;
                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                    if (((next$iv$iv.getKindSet() & type$iv4) != 0 ? i5 : 0) == 0) {
                                        type$iv3 = type$iv4;
                                        i3 = i4;
                                    } else {
                                        count$iv$iv++;
                                        if (count$iv$iv == i5) {
                                            node = next$iv$iv;
                                            type$iv3 = type$iv4;
                                            i3 = i4;
                                        } else {
                                            if (mutableVector2 != null) {
                                                type$iv3 = type$iv4;
                                                i3 = i4;
                                                mutableVector = mutableVector2;
                                            } else {
                                                type$iv3 = type$iv4;
                                                i3 = i4;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            mutableVector2 = mutableVector;
                                            Modifier.Node theNode$iv$iv = node;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(theNode$iv$iv);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(next$iv$iv);
                                            }
                                        }
                                    }
                                    node$iv$iv$iv = node$iv$iv$iv.getChild();
                                    type$iv4 = type$iv3;
                                    i4 = i3;
                                    i5 = 1;
                                }
                                type$iv2 = type$iv4;
                                i2 = i4;
                                if (count$iv$iv == 1) {
                                    this_$iv3 = this_$iv2;
                                    type$iv4 = type$iv2;
                                    i4 = i2;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        this_$iv3 = this_$iv2;
                        type$iv4 = type$iv2;
                        i4 = i2;
                    }
                    type$iv = type$iv4;
                    this_$iv = this_$iv3;
                    i = i4;
                }
                if (node$iv$iv == stopNode$iv$iv) {
                    return;
                }
                node$iv$iv = node$iv$iv.getChild();
                this_$iv3 = this_$iv;
                type$iv4 = type$iv;
                i4 = i;
            }
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(final Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayoutNode().isPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invoke$1
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
                    NodeCoordinator.this.drawContainedDrawModifiers(canvas);
                }
            });
            this.lastLayerDrawingWasSkipped = false;
        } else {
            this.lastLayerDrawingWasSkipped = true;
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock, boolean forceUpdateLayerParameters) {
        Owner owner;
        LayoutNode layoutNode = getLayoutNode();
        boolean updateParameters = (!forceUpdateLayerParameters && this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerBlock = layerBlock;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (isAttached() && layerBlock != null) {
            if (this.layer == null) {
                OwnedLayer $this$updateLayerBlock_u24lambda_u2413 = LayoutNodeKt.requireOwner(layoutNode).createLayer(this, this.invalidateParentLayer);
                $this$updateLayerBlock_u24lambda_u2413.mo4449resizeozmzZPI(getMeasuredSize());
                $this$updateLayerBlock_u24lambda_u2413.mo4448movegyyYBs(getPosition());
                this.layer = $this$updateLayerBlock_u24lambda_u2413;
                updateLayerParameters$default(this, false, 1, null);
                layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                return;
            }
            if (updateParameters) {
                updateLayerParameters$default(this, false, 1, null);
                return;
            }
            return;
        }
        OwnedLayer it = this.layer;
        if (it != null) {
            it.destroy();
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner = layoutNode.getOwner()) != null) {
                owner.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        nodeCoordinator.updateLayerParameters(z);
    }

    private final void updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner;
        OwnedLayer layer = this.layer;
        if (layer == null) {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            return;
        }
        final Function1 layerBlock = this.layerBlock;
        if (layerBlock == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        graphicsLayerScope.reset();
        graphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
        graphicsLayerScope.m3254setSizeuvyYCjk(IntSizeKt.m5388toSizeozmzZPI(mo4193getSizeYbymL2g()));
        getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                ReusableGraphicsLayerScope reusableGraphicsLayerScope;
                Function1<GraphicsLayerScope, Unit> function1 = layerBlock;
                reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                function1.invoke(reusableGraphicsLayerScope);
            }
        });
        LayerPositionalProperties it = this.layerPositionalProperties;
        if (it == null) {
            it = new LayerPositionalProperties();
            this.layerPositionalProperties = it;
        }
        LayerPositionalProperties layerPositionalProperties = it;
        layerPositionalProperties.copyFrom(graphicsLayerScope);
        layer.mo4451updateLayerPropertiesdDxrwY(graphicsLayerScope.getScaleX(), graphicsLayerScope.getScaleY(), graphicsLayerScope.getAlpha(), graphicsLayerScope.getTranslationX(), graphicsLayerScope.getTranslationY(), graphicsLayerScope.getShadowElevation(), graphicsLayerScope.getRotationX(), graphicsLayerScope.getRotationY(), graphicsLayerScope.getRotationZ(), graphicsLayerScope.getCameraDistance(), graphicsLayerScope.getTransformOrigin(), graphicsLayerScope.getShape(), graphicsLayerScope.getClip(), graphicsLayerScope.getRenderEffect(), graphicsLayerScope.getAmbientShadowColor(), graphicsLayerScope.getSpotShadowColor(), graphicsLayerScope.getCompositingStrategy(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
        this.isClipping = graphicsLayerScope.getClip();
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        if (!invokeOnLayoutChange || (owner = getLayoutNode().getOwner()) == null) {
            return;
        }
        owner.onLayoutChange(getLayoutNode());
    }

    /* renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.layer != null && isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m4385getMinimumTouchTargetSizeNHjbRc() {
        Density $this$getMinimumTouchTargetSize_NH_jbRc_u24lambda_u2416 = this.layerDensity;
        return $this$getMinimumTouchTargetSize_NH_jbRc_u24lambda_u2416.mo330toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo4329getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final void m4387hitTestYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        Modifier.Node head = m4386headH91voCI(hitTestSource.mo4396entityTypeOLwlOKw());
        if (!m4394withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (isTouchEvent) {
                float distanceFromEdge = m4382distanceInMinimumTouchTargettz77jQw(pointerPosition, m4385getMinimumTouchTargetSizeNHjbRc());
                if (((Float.isInfinite(distanceFromEdge) || Float.isNaN(distanceFromEdge)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(distanceFromEdge, false)) {
                    m4375hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, distanceFromEdge);
                    return;
                }
                return;
            }
            return;
        }
        if (head == null) {
            mo4320hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        if (m4388isPointerInBoundsk4lQ0M(pointerPosition)) {
            m4374hit1hIXUjU(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        float distanceFromEdge2 = !isTouchEvent ? Float.POSITIVE_INFINITY : m4382distanceInMinimumTouchTargettz77jQw(pointerPosition, m4385getMinimumTouchTargetSizeNHjbRc());
        if (((Float.isInfinite(distanceFromEdge2) || Float.isNaN(distanceFromEdge2)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(distanceFromEdge2, isInLayer)) {
            m4375hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
        } else {
            m4378speculativeHitJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU, reason: not valid java name */
    public final void m4374hit1hIXUjU(final Modifier.Node $this$hit_u2d1hIXUjU, final HitTestSource hitTestSource, final long pointerPosition, final HitTestResult hitTestResult, final boolean isTouchEvent, final boolean isInLayer) {
        if ($this$hit_u2d1hIXUjU == null) {
            mo4320hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else {
            hitTestResult.hit($this$hit_u2d1hIXUjU, isInLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
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
                    Modifier.Node m4398nextUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m4398nextUntilhw7D004 = NodeCoordinatorKt.m4398nextUntilhw7D004($this$hit_u2d1hIXUjU, hitTestSource.mo4396entityTypeOLwlOKw(), NodeKind.m4400constructorimpl(2));
                    nodeCoordinator.m4374hit1hIXUjU(m4398nextUntilhw7D004, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final void m4375hitNearJHbHoSQ(final Modifier.Node $this$hitNear_u2dJHbHoSQ, final HitTestSource hitTestSource, final long pointerPosition, final HitTestResult hitTestResult, final boolean isTouchEvent, final boolean isInLayer, final float distanceFromEdge) {
        if ($this$hitNear_u2dJHbHoSQ == null) {
            mo4320hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else {
            hitTestResult.hitInMinimumTouchTarget($this$hitNear_u2dJHbHoSQ, distanceFromEdge, isInLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
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
                    Modifier.Node m4398nextUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m4398nextUntilhw7D004 = NodeCoordinatorKt.m4398nextUntilhw7D004($this$hitNear_u2dJHbHoSQ, hitTestSource.mo4396entityTypeOLwlOKw(), NodeKind.m4400constructorimpl(2));
                    nodeCoordinator.m4375hitNearJHbHoSQ(m4398nextUntilhw7D004, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final void m4378speculativeHitJHbHoSQ(final Modifier.Node $this$speculativeHit_u2dJHbHoSQ, final HitTestSource hitTestSource, final long pointerPosition, final HitTestResult hitTestResult, final boolean isTouchEvent, final boolean isInLayer, final float distanceFromEdge) {
        if ($this$speculativeHit_u2dJHbHoSQ != null) {
            if (hitTestSource.interceptOutOfBoundsChildEvents($this$speculativeHit_u2dJHbHoSQ)) {
                hitTestResult.speculativeHit($this$speculativeHit_u2dJHbHoSQ, distanceFromEdge, isInLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
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
                        Modifier.Node m4398nextUntilhw7D004;
                        NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                        m4398nextUntilhw7D004 = NodeCoordinatorKt.m4398nextUntilhw7D004($this$speculativeHit_u2dJHbHoSQ, hitTestSource.mo4396entityTypeOLwlOKw(), NodeKind.m4400constructorimpl(2));
                        nodeCoordinator.m4378speculativeHitJHbHoSQ(m4398nextUntilhw7D004, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
                    }
                });
                return;
            } else {
                m4378speculativeHitJHbHoSQ(NodeCoordinatorKt.m4397access$nextUntilhw7D004($this$speculativeHit_u2dJHbHoSQ, hitTestSource.mo4396entityTypeOLwlOKw(), NodeKind.m4400constructorimpl(2)), hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
                return;
            }
        }
        mo4320hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
    }

    /* renamed from: hitTestChild-YqVAtuI */
    public void mo4320hitTestChildYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator wrapped = this.wrapped;
        if (wrapped != null) {
            long positionInWrapped = wrapped.m4383fromParentPositionMKHz9U(pointerPosition);
            wrapped.m4387hitTestYqVAtuI(hitTestSource, positionInWrapped, hitTestResult, isTouchEvent, isInLayer);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect bounds = getRectCache();
        long padding = m4381calculateMinimumTouchTargetPaddingE7KxVPU(m4385getMinimumTouchTargetSizeNHjbRc());
        bounds.setLeft(-Size.m2779getWidthimpl(padding));
        bounds.setTop(-Size.m2776getHeightimpl(padding));
        bounds.setRight(getMeasuredWidth() + Size.m2779getWidthimpl(padding));
        bounds.setBottom(getMeasuredHeight() + Size.m2776getHeightimpl(padding));
        NodeCoordinator coordinator = this;
        while (coordinator != root) {
            coordinator.rectInParent$ui_release(bounds, false, true);
            if (bounds.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            coordinator = nodeCoordinator;
        }
        return MutableRectKt.toRect(bounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo4198windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
        long positionInRoot = Offset.m2714minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo4452calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(root));
        return mo4194localPositionOfR5De75A(root, positionInRoot);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo4196localToWindowMKHz9U(long relativeToLocal) {
        long positionInRoot = mo4195localToRootMKHz9U(relativeToLocal);
        Owner owner = LayoutNodeKt.requireOwner(getLayoutNode());
        return owner.mo4453calculatePositionInWindowMKHz9U(positionInRoot);
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates $this$toCoordinator) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = $this$toCoordinator instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) $this$toCoordinator : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull($this$toCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) $this$toCoordinator;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo4194localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (sourceCoordinates instanceof LookaheadLayoutCoordinatesImpl) {
            return Offset.m2719unaryMinusF1C5BW0(sourceCoordinates.mo4194localPositionOfR5De75A(this, Offset.m2719unaryMinusF1C5BW0(relativeToSource)));
        }
        NodeCoordinator nodeCoordinator = toCoordinator(sourceCoordinates);
        nodeCoordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(nodeCoordinator);
        long position = relativeToSource;
        NodeCoordinator coordinator = nodeCoordinator;
        while (coordinator != commonAncestor) {
            position = coordinator.m4392toParentPositionMKHz9U(position);
            NodeCoordinator nodeCoordinator2 = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            coordinator = nodeCoordinator2;
        }
        return m4372ancestorToLocalR5De75A(commonAncestor, position);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo4197transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(coordinator);
        Matrix.m3183resetimpl(matrix);
        coordinator.m4380transformToAncestorEL8BTi8(commonAncestor, matrix);
        m4379transformFromAncestorEL8BTi8(commonAncestor, matrix);
    }

    /* renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m4380transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator wrapper = this;
        while (!Intrinsics.areEqual(wrapper, ancestor)) {
            OwnedLayer ownedLayer = wrapper.layer;
            if (ownedLayer != null) {
                ownedLayer.mo4450transform58bKbWc(matrix);
            }
            long position = wrapper.getPosition();
            if (!IntOffset.m5335equalsimpl0(position, IntOffset.INSTANCE.m5346getZeronOccac())) {
                Matrix.m3183resetimpl(tmpMatrix);
                Matrix.m3194translateimpl$default(tmpMatrix, IntOffset.m5336getXimpl(position), IntOffset.m5337getYimpl(position), 0.0f, 4, null);
                Matrix.m3191timesAssign58bKbWc(matrix, tmpMatrix);
            }
            NodeCoordinator nodeCoordinator = wrapper.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            wrapper = nodeCoordinator;
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m4379transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (!Intrinsics.areEqual(ancestor, this)) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            nodeCoordinator.m4379transformFromAncestorEL8BTi8(ancestor, matrix);
            if (!IntOffset.m5335equalsimpl0(getPosition(), IntOffset.INSTANCE.m5346getZeronOccac())) {
                Matrix.m3183resetimpl(tmpMatrix);
                Matrix.m3194translateimpl$default(tmpMatrix, -IntOffset.m5336getXimpl(getPosition()), -IntOffset.m5337getYimpl(getPosition()), 0.0f, 4, null);
                Matrix.m3191timesAssign58bKbWc(matrix, tmpMatrix);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo4445inverseTransform58bKbWc(matrix);
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        if (!sourceCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
        NodeCoordinator srcCoordinator = toCoordinator(sourceCoordinates);
        srcCoordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(srcCoordinator);
        MutableRect bounds = getRectCache();
        bounds.setLeft(0.0f);
        bounds.setTop(0.0f);
        bounds.setRight(IntSize.m5378getWidthimpl(sourceCoordinates.mo4193getSizeYbymL2g()));
        bounds.setBottom(IntSize.m5377getHeightimpl(sourceCoordinates.mo4193getSizeYbymL2g()));
        NodeCoordinator coordinator = srcCoordinator;
        while (coordinator != commonAncestor) {
            rectInParent$ui_release$default(coordinator, bounds, clipBounds, false, 4, null);
            if (bounds.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            coordinator = nodeCoordinator;
        }
        ancestorToLocal(commonAncestor, bounds, clipBounds);
        return MutableRectKt.toRect(bounds);
    }

    /* renamed from: ancestorToLocal-R5De75A, reason: not valid java name */
    private final long m4372ancestorToLocalR5De75A(NodeCoordinator ancestor, long offset) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator wrappedBy = this.wrappedBy;
        if (wrappedBy == null || Intrinsics.areEqual(ancestor, wrappedBy)) {
            return m4383fromParentPositionMKHz9U(offset);
        }
        return m4383fromParentPositionMKHz9U(wrappedBy.m4372ancestorToLocalR5De75A(ancestor, offset));
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo4195localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        onCoordinatesUsed$ui_release();
        long position = relativeToLocal;
        for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrappedBy) {
            position = coordinator.m4392toParentPositionMKHz9U(position);
        }
        return position;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(block, "block");
        float x = IntOffset.m5336getXimpl(getPosition());
        float y = IntOffset.m5337getYimpl(getPosition());
        canvas.translate(x, y);
        block.invoke(canvas);
        canvas.translate(-x, -y);
    }

    /* renamed from: toParentPosition-MK-Hz9U, reason: not valid java name */
    public long m4392toParentPositionMKHz9U(long position) {
        OwnedLayer layer = this.layer;
        long targetPosition = layer != null ? layer.mo4447mapOffset8S9VItk(position, false) : position;
        return IntOffsetKt.m5350plusNvtHpc(targetPosition, getPosition());
    }

    /* renamed from: fromParentPosition-MK-Hz9U, reason: not valid java name */
    public long m4383fromParentPositionMKHz9U(long position) {
        long relativeToPosition = IntOffsetKt.m5348minusNvtHpc(position, getPosition());
        OwnedLayer layer = this.layer;
        return layer != null ? layer.mo4447mapOffset8S9VItk(relativeToPosition, true) : relativeToPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Rect rect = new Rect(0.5f, 0.5f, IntSize.m5378getWidthimpl(getMeasuredSize()) - 0.5f, IntSize.m5377getHeightimpl(getMeasuredSize()) - 0.5f);
        canvas.drawRect(rect, paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        if (this.layer != null) {
            updateLayerBlock$default(this, null, false, 2, null);
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        OwnedLayer layer = this.layer;
        if (layer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long minTouch = m4385getMinimumTouchTargetSizeNHjbRc();
                    float horz = Size.m2779getWidthimpl(minTouch) / 2.0f;
                    float vert = Size.m2776getHeightimpl(minTouch) / 2.0f;
                    bounds.intersect(-horz, -vert, IntSize.m5378getWidthimpl(mo4193getSizeYbymL2g()) + horz, IntSize.m5377getHeightimpl(mo4193getSizeYbymL2g()) + vert);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m5378getWidthimpl(mo4193getSizeYbymL2g()), IntSize.m5377getHeightimpl(mo4193getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            layer.mapBounds(bounds, false);
        }
        int x = IntOffset.m5336getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + x);
        bounds.setRight(bounds.getRight() + x);
        int y = IntOffset.m5337getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + y);
        bounds.setBottom(bounds.getBottom() + y);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        int x = IntOffset.m5336getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - x);
        bounds.setRight(bounds.getRight() - x);
        int y = IntOffset.m5337getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - y);
        bounds.setBottom(bounds.getBottom() - y);
        OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, IntSize.m5378getWidthimpl(mo4193getSizeYbymL2g()), IntSize.m5377getHeightimpl(mo4193getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    public final boolean m4394withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m2727isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer layer = this.layer;
        return layer == null || !this.isClipping || layer.mo4446isInLayerk4lQ0M(pointerPosition);
    }

    /* renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m4388isPointerInBoundsk4lQ0M(long pointerPosition) {
        float x = Offset.m2710getXimpl(pointerPosition);
        float y = Offset.m2711getYimpl(pointerPosition);
        return x >= 0.0f && y >= 0.0f && x < ((float) getMeasuredWidth()) && y < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator $this, Rect rect, Continuation<? super Unit> continuation) {
        NodeCoordinator parent = $this.wrappedBy;
        if (parent == null) {
            return Unit.INSTANCE;
        }
        Rect boundingBoxInParentCoordinates = parent.localBoundingBoxOf($this, false);
        Rect rectInParentBounds = rect.m2747translatek4lQ0M(boundingBoxInParentCoordinates.m2745getTopLeftF1C5BW0());
        Object propagateRelocationRequest = parent.propagateRelocationRequest(rectInParentBounds, continuation);
        return propagateRelocationRequest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        Intrinsics.checkNotNullParameter(other, "other");
        LayoutNode ancestor1 = other.getLayoutNode();
        LayoutNode ancestor2 = getLayoutNode();
        if (ancestor1 == ancestor2) {
            Modifier.Node otherNode = other.getTail();
            DelegatableNode $this$visitLocalAncestors$iv = getTail();
            int m4400constructorimpl = NodeKind.m4400constructorimpl(2);
            if (!$this$visitLocalAncestors$iv.getNode().getIsAttached()) {
                throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
            }
            for (Modifier.Node next$iv = $this$visitLocalAncestors$iv.getNode().getParent(); next$iv != null; next$iv = next$iv.getParent()) {
                if ((next$iv.getKindSet() & m4400constructorimpl) != 0) {
                    Modifier.Node it = next$iv;
                    if (it == otherNode) {
                        return other;
                    }
                }
            }
            return this;
        }
        while (ancestor1.getDepth() > ancestor2.getDepth()) {
            LayoutNode parent$ui_release = ancestor1.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            ancestor1 = parent$ui_release;
        }
        while (ancestor2.getDepth() > ancestor1.getDepth()) {
            LayoutNode parent$ui_release2 = ancestor2.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release2);
            ancestor2 = parent$ui_release2;
        }
        while (ancestor1 != ancestor2) {
            LayoutNode parent1 = ancestor1.getParent$ui_release();
            LayoutNode parent2 = ancestor2.getParent$ui_release();
            if (parent1 == null || parent2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
            ancestor1 = parent1;
            ancestor2 = parent2;
        }
        return ancestor2 == getLayoutNode() ? this : ancestor1 == other.getLayoutNode() ? other : ancestor1.getInnerCoordinator$ui_release();
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        int type$iv;
        int type$iv2;
        int count$iv$iv;
        MutableVector mutableVector;
        Modifier.Node start = headNode(NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(NodeKind.m4400constructorimpl(16)));
        if (start == null) {
            return false;
        }
        Modifier.Node $this$visitLocalDescendants_u2d6rFNWt0$iv = start;
        int type$iv3 = NodeKind.m4400constructorimpl(16);
        if (!$this$visitLocalDescendants_u2d6rFNWt0$iv.getNode().getIsAttached()) {
            throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
        }
        Modifier.Node self$iv$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv.getNode();
        if ((self$iv$iv.getAggregateChildKindSet() & type$iv3) == 0) {
            return false;
        }
        Modifier.Node next$iv$iv = self$iv$iv.getChild();
        while (next$iv$iv != null) {
            if ((next$iv$iv.getKindSet() & type$iv3) != 0) {
                Modifier.Node it$iv = next$iv$iv;
                MutableVector mutableVector2 = null;
                Modifier.Node node = it$iv;
                while (node != null) {
                    Modifier.Node start2 = start;
                    int i = 1;
                    if (node instanceof PointerInputModifierNode) {
                        PointerInputModifierNode it = (PointerInputModifierNode) node;
                        if (it.sharePointerInputWithSiblings()) {
                            return true;
                        }
                        type$iv = type$iv3;
                    } else {
                        Modifier.Node this_$iv$iv$iv = node;
                        Modifier.Node this_$iv$iv$iv2 = (this_$iv$iv$iv.getKindSet() & type$iv3) != 0 ? 1 : null;
                        if (this_$iv$iv$iv2 == null || !(node instanceof DelegatingNode)) {
                            type$iv = type$iv3;
                        } else {
                            int count$iv$iv2 = 0;
                            DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) node;
                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate();
                            while (node$iv$iv$iv != null) {
                                Modifier.Node next$iv$iv2 = node$iv$iv$iv;
                                if (((next$iv$iv2.getKindSet() & type$iv3) != 0 ? i : 0) == 0) {
                                    type$iv2 = type$iv3;
                                } else {
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i) {
                                        node = next$iv$iv2;
                                        type$iv2 = type$iv3;
                                    } else {
                                        if (mutableVector2 != null) {
                                            count$iv$iv = count$iv$iv2;
                                            type$iv2 = type$iv3;
                                            mutableVector = mutableVector2;
                                        } else {
                                            count$iv$iv = count$iv$iv2;
                                            type$iv2 = type$iv3;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        mutableVector2 = mutableVector;
                                        Modifier.Node theNode$iv$iv = node;
                                        if (theNode$iv$iv != null) {
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(theNode$iv$iv);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(next$iv$iv2);
                                        }
                                        count$iv$iv2 = count$iv$iv;
                                    }
                                }
                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                type$iv3 = type$iv2;
                                i = 1;
                            }
                            type$iv = type$iv3;
                            if (count$iv$iv2 == 1) {
                                start = start2;
                                type$iv3 = type$iv;
                            }
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector2);
                    start = start2;
                    type$iv3 = type$iv;
                }
            }
            next$iv$iv = next$iv$iv.getChild();
            start = start;
            type$iv3 = type$iv3;
        }
        return false;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m4376offsetFromEdgeMKHz9U(long pointerPosition) {
        float x = Offset.m2710getXimpl(pointerPosition);
        float horizontal = Math.max(0.0f, x < 0.0f ? -x : x - getMeasuredWidth());
        float y = Offset.m2711getYimpl(pointerPosition);
        float vertical = Math.max(0.0f, y < 0.0f ? -y : y - getMeasuredHeight());
        return OffsetKt.Offset(horizontal, vertical);
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m4381calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        float widthDiff = Size.m2779getWidthimpl(minimumTouchTargetSize) - getMeasuredWidth();
        float heightDiff = Size.m2776getHeightimpl(minimumTouchTargetSize) - getMeasuredHeight();
        return SizeKt.Size(Math.max(0.0f, widthDiff / 2.0f), Math.max(0.0f, heightDiff / 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    public final float m4382distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Size.m2779getWidthimpl(minimumTouchTargetSize) && getMeasuredHeight() >= Size.m2776getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long m4381calculateMinimumTouchTargetPaddingE7KxVPU = m4381calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float width = Size.m2779getWidthimpl(m4381calculateMinimumTouchTargetPaddingE7KxVPU);
        float height = Size.m2776getHeightimpl(m4381calculateMinimumTouchTargetPaddingE7KxVPU);
        long offsetFromEdge = m4376offsetFromEdgeMKHz9U(pointerPosition);
        if ((width > 0.0f || height > 0.0f) && Offset.m2710getXimpl(offsetFromEdge) <= width && Offset.m2711getYimpl(offsetFromEdge) <= height) {
            return Offset.m2709getDistanceSquaredimpl(offsetFromEdge);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }
}
