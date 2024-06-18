package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: LayoutNode.kt */
@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b?\b\u0000\u0018\u0000 à\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\bà\u0002á\u0002â\u0002ã\u0002B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010ä\u0001\u001a\u00030µ\u00012\b\u0010¿\u0001\u001a\u00030´\u0001H\u0000¢\u0006\u0003\bå\u0001J\u0010\u0010æ\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bç\u0001J\n\u0010è\u0001\u001a\u00030µ\u0001H\u0002J\u0014\u0010é\u0001\u001a\u00030ê\u00012\b\b\u0002\u0010H\u001a\u00020\u000bH\u0002J\u0010\u0010ë\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bì\u0001J\u0010\u0010í\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bî\u0001J\u001a\u0010ï\u0001\u001a\u00030µ\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0000¢\u0006\u0003\bò\u0001J%\u0010ó\u0001\u001a\u00030µ\u00012\u0015\u0010ô\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030µ\u00010³\u0001H\u0086\bø\u0001\u0000J+\u0010õ\u0001\u001a\u00030µ\u00012\u001b\u0010ô\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030µ\u00010ö\u0001H\u0086\bø\u0001\u0000J,\u0010÷\u0001\u001a\u00030µ\u00012\u0016\u0010ô\u0001\u001a\u0011\u0012\u0005\u0012\u00030ø\u0001\u0012\u0005\u0012\u00030µ\u00010³\u0001H\u0080\bø\u0001\u0000¢\u0006\u0003\bù\u0001J+\u0010ú\u0001\u001a\u00030µ\u00012\u0015\u0010ô\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030µ\u00010³\u0001H\u0080\bø\u0001\u0000¢\u0006\u0003\bû\u0001J\n\u0010ü\u0001\u001a\u00030µ\u0001H\u0016J\u0013\u0010ý\u0001\u001a\f\u0018\u00010þ\u0001j\u0005\u0018\u0001`ÿ\u0001H\u0017J\u0010\u0010\u0080\u0002\u001a\t\u0012\u0005\u0012\u00030\u0081\u00020$H\u0016JC\u0010\u0082\u0002\u001a\u00030µ\u00012\b\u0010\u0083\u0002\u001a\u00030\u0084\u00022\b\u0010\u0085\u0002\u001a\u00030\u0086\u00022\t\b\u0002\u0010\u0087\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0088\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002JC\u0010\u008b\u0002\u001a\u00030µ\u00012\b\u0010\u0083\u0002\u001a\u00030\u0084\u00022\b\u0010\u008c\u0002\u001a\u00030\u0086\u00022\t\b\u0002\u0010\u0087\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0088\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u008d\u0002\u0010\u008a\u0002J$\u0010Q\u001a\u00030µ\u00012\u000f\u0010ô\u0001\u001a\n\u0012\u0005\u0012\u00030µ\u00010\u008e\u0002H\u0080\bø\u0001\u0000¢\u0006\u0003\b\u008f\u0002J\"\u0010\u0090\u0002\u001a\u00030µ\u00012\u0007\u0010\u0091\u0002\u001a\u00020\u000b2\u0007\u0010\u0092\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0093\u0002J\n\u0010\u0094\u0002\u001a\u00030µ\u0001H\u0002J\n\u0010\u0095\u0002\u001a\u00030µ\u0001H\u0002J\u0010\u0010\u0096\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0097\u0002J\u0010\u0010\u0098\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0099\u0002J\u0010\u0010\u009a\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u009b\u0002J\u0010\u0010\u009c\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u009d\u0002J\u0010\u0010\u009e\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u009f\u0002J\u0013\u0010 \u0002\u001a\u00030µ\u00012\t\b\u0002\u0010¡\u0002\u001a\u00020\tJ\n\u0010¢\u0002\u001a\u00030µ\u0001H\u0002J#\u0010£\u0002\u001a\u00020\t2\f\b\u0002\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b¦\u0002J\u0010\u0010§\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¨\u0002J\u0010\u0010©\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bª\u0002J\u0010\u0010«\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¬\u0002J\u0010\u0010\u00ad\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b®\u0002J\u0010\u0010¯\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b°\u0002J+\u0010±\u0002\u001a\u00030µ\u00012\u0007\u0010²\u0002\u001a\u00020\u000b2\u0007\u0010³\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bµ\u0002J\u0013\u0010¶\u0002\u001a\u00030µ\u00012\u0007\u0010·\u0002\u001a\u00020\u0000H\u0002J\n\u0010¸\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010¹\u0002\u001a\u00030µ\u0001H\u0002J\n\u0010º\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010»\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010¼\u0002\u001a\u00030µ\u0001H\u0016J\u0010\u0010½\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¾\u0002J\"\u0010¿\u0002\u001a\u00030µ\u00012\u0007\u0010À\u0002\u001a\u00020\u000b2\u0007\u0010Á\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÂ\u0002J\n\u0010Ã\u0002\u001a\u00030µ\u0001H\u0002J#\u0010Ä\u0002\u001a\u00020\t2\f\b\u0002\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\bÅ\u0002J\u0010\u0010Æ\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bÇ\u0002J\"\u0010È\u0002\u001a\u00030µ\u00012\u0007\u0010\u0091\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÉ\u0002J\u0010\u0010Ê\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bË\u0002J\u001b\u0010Ì\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÎ\u0002J&\u0010Ï\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\t2\t\b\u0002\u0010Ð\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÑ\u0002J\u001b\u0010Ò\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÓ\u0002J&\u0010Ô\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\t2\t\b\u0002\u0010Ð\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÕ\u0002J\u0019\u0010Ö\u0002\u001a\u00030µ\u00012\u0007\u0010×\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bØ\u0002J\n\u0010Ù\u0002\u001a\u00030µ\u0001H\u0002J\u0010\u0010Ú\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bÛ\u0002J\t\u0010Ü\u0002\u001a\u00020\tH\u0002J\n\u0010Ý\u0002\u001a\u00030ê\u0001H\u0016J\u0010\u0010Þ\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bß\u0002R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R,\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b8W@WX\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00108\u001a\u0002072\u0006\u00106\u001a\u000207@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010C\u001a\u00020B2\u0006\u00106\u001a\u00020B@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010'R\u0014\u0010M\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u001cR\u0014\u0010O\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u00103R\u000e\u0010Q\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010U\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u001a\u0010W\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010\"R\"\u0010Z\u001a\n\u0018\u00010[j\u0004\u0018\u0001`\\X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u001cR\u0014\u0010l\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u001cR\u0013\u0010m\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010p\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u001c\"\u0004\br\u0010\"R\u0014\u0010s\u001a\u00020tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR$\u0010x\u001a\u00020w2\u0006\u00106\u001a\u00020w@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0014\u0010}\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u001cR\u0017\u0010\u007f\u001a\u00030\u0080\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0083\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u001cR\u0016\u0010\u0085\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\u001cR\u001e\u0010\u0087\u0001\u001a\t\u0018\u00010\u0088\u0001R\u00020t8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R.\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00002\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0092\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0095\u0001\u001a\u00070\u0096\u0001R\u00020t8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0016\u0010\u0099\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010\u001cR+\u0010\u009c\u0001\u001a\u00030\u009b\u00012\u0007\u00106\u001a\u00030\u009b\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00020f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010hR\u0016\u0010£\u0001\u001a\u00020f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010hR+\u0010¦\u0001\u001a\u00030¥\u00012\u0007\u00106\u001a\u00030¥\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010«\u0001\u001a\u00020\tX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u001c\"\u0005\b\u00ad\u0001\u0010\"R\u0018\u0010®\u0001\u001a\u00030¯\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b°\u0001\u0010±\u0001R0\u0010²\u0001\u001a\u0013\u0012\u0005\u0012\u00030´\u0001\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010³\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R0\u0010º\u0001\u001a\u0013\u0012\u0005\u0012\u00030´\u0001\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010³\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010·\u0001\"\u0006\b¼\u0001\u0010¹\u0001R\u0016\u0010½\u0001\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010TR'\u0010¿\u0001\u001a\u0005\u0018\u00010´\u00012\t\u0010/\u001a\u0005\u0018\u00010´\u0001@BX\u0080\u000e¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Â\u0001\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010\u008e\u0001R\u0019\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0016\u0010Ç\u0001\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÈ\u0001\u00103R\u000f\u0010É\u0001\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u00103\"\u0005\bË\u0001\u00105R\"\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R\u000f\u0010Ò\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010Ô\u0001\u001a\u00030Ó\u00012\u0007\u00106\u001a\u00030Ó\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\u000f\u0010Ù\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ú\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÛ\u0001\u00103R\u0018\u0010Ü\u0001\u001a\u00030Ý\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R#\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0081\u0004¢\u0006\u000e\u0012\u0005\bá\u0001\u0010\u001f\u001a\u0005\bâ\u0001\u0010\u0010R\u000f\u0010ã\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006ä\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_collapsedSemantics", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "collapsedSemantics", "getCollapsedSemantics$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<set-?>", "compositeKeyHash", "getCompositeKeyHash$annotations", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "value", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "deactivated", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "setDepth$ui_release", "foldedChildren", "getFoldedChildren$ui_release", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isPlaced", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValidOwnerScope", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "setVirtualLookaheadRoot$ui_release", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "getSemanticsId", "setSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "getZIndex", "()F", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "attach", "attach$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui_release", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui_release", "forceRemeasure", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateFocusOnAttach", "invalidateFocusOnDetach", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateParentData", "invalidateParentData$ui_release", "invalidateSemantics", "invalidateSemantics$ui_release", "invalidateSubtree", "isRootOfInvalidation", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDeactivate", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onRelease", "onReuse", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "scheduleMeasureAndLayout", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetModifierState", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private SemanticsConfiguration _collapsedSemantics;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private boolean deactivated;
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private Owner owner;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo15measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List measurables, long constraints) {
            return (MeasureResult) m4330measure3p2s80s($this$measure_u2d3p2s80s, (List<? extends Measurable>) measurables, constraints);
        }

        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m4330measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };
    private static final Function0<LayoutNode> Constructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long mo4329getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.INSTANCE.m5326getZeroMYxV2XQ();
        }
    };
    private static final Comparator<LayoutNode> ZComparator = new Comparator() { // from class: androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int ZComparator$lambda$38;
            ZComparator$lambda$38 = LayoutNode.ZComparator$lambda$38((LayoutNode) obj, (LayoutNode) obj2);
            return ZComparator$lambda$38;
        }
    };

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode() {
        this(false, 0, 3, null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getCompositeKeyHash$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public LayoutNode(boolean isVirtual, int semanticsId) {
        Density density;
        this.isVirtual = isVirtual;
        this.semanticsId = semanticsId;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
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
                LayoutNode.this.getLayoutDelegate().markChildrenDirty();
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        density = LayoutNodeKt.DefaultDensity;
        this.density = density;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.INSTANCE.getEmpty();
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.INSTANCE;
    }

    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierKt.generateSemanticsId() : i);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getSemanticsId() {
        return this.semanticsId;
    }

    public void setSemanticsId(int i) {
        this.semanticsId = i;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositeKeyHash(int i) {
        this.compositeKeyHash = i;
    }

    /* renamed from: isVirtualLookaheadRoot$ui_release, reason: from getter */
    public final boolean getIsVirtualLookaheadRoot() {
        return this.isVirtualLookaheadRoot;
    }

    public final void setVirtualLookaheadRoot$ui_release(boolean z) {
        this.isVirtualLookaheadRoot = z;
    }

    /* renamed from: getLookaheadRoot$ui_release, reason: from getter */
    public final LayoutNode getLookaheadRoot() {
        return this.lookaheadRoot;
    }

    private final void setLookaheadRoot(LayoutNode newRoot) {
        if (!Intrinsics.areEqual(newRoot, this.lookaheadRoot)) {
            this.lookaheadRoot = newRoot;
            if (newRoot != null) {
                this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
                NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped();
                for (NodeCoordinator delegate$iv = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate$iv, final$iv) && delegate$iv != null; delegate$iv = delegate$iv.getWrapped()) {
                    NodeCoordinator it = delegate$iv;
                    it.ensureLookaheadDelegateCreated();
                }
            }
            invalidateMeasurements$ui_release();
        }
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            return Boolean.valueOf(lookaheadPassDelegate$ui_release.isPlaced());
        }
        return null;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                MutableVector it = new MutableVector(new LayoutNode[16], 0);
                this._unfoldedChildren = it;
                mutableVector = it;
            }
            MutableVector unfoldedChildren = mutableVector;
            unfoldedChildren.clear();
            MutableVectorWithMutationTracking this_$iv = this._foldedChildren;
            MutableVector this_$iv$iv = this_$iv.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it2.isVirtual) {
                        MutableVector elements$iv = it2.get_children$ui_release();
                        unfoldedChildren.addAll(unfoldedChildren.getSize(), elements$iv);
                    } else {
                        unfoldedChildren.add(it2);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.getChildDelegates$ui_release();
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (layoutNode = this._foldedParent) == null) {
            return;
        }
        layoutNode.invalidateUnfoldedVirtualChildren();
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv.getContent();
        do {
            block.invoke(content$iv[i$iv]);
            i$iv++;
        } while (i$iv < size$iv);
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv.getContent();
        do {
            block.invoke(Integer.valueOf(i$iv), content$iv[i$iv]);
            i$iv++;
        } while (i$iv < size$iv);
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode parent = this._foldedParent;
        while (true) {
            boolean z = false;
            if (parent != null && parent.isVirtual) {
                z = true;
            }
            if (z) {
                parent = parent._foldedParent;
            } else {
                return parent;
            }
        }
    }

    /* renamed from: getOwner$ui_release, reason: from getter */
    public final Owner getOwner() {
        return this.owner;
    }

    /* renamed from: getInteropViewFactoryHolder$ui_release, reason: from getter */
    public final AndroidViewHolder getInteropViewFactoryHolder() {
        return this.interopViewFactoryHolder;
    }

    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    @Override // androidx.compose.ui.node.InteroperableComposeUiNode
    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getView();
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isAttached() {
        return this.owner != null;
    }

    /* renamed from: getDepth$ui_release, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    public final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    public final void insertAt$ui_release(int index, LayoutNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (!(instance._foldedParent == null)) {
            StringBuilder append = new StringBuilder().append("Cannot insert ").append(instance).append(" because it already has a parent. This tree: ").append(debugTreeToString$default(this, 0, 1, null)).append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            throw new IllegalStateException(append.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null).toString().toString());
        }
        if (!(instance.owner == null)) {
            throw new IllegalStateException(("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, null)).toString());
        }
        instance._foldedParent = this;
        this._foldedChildren.add(index, instance);
        onZSortedChildrenInvalidated$ui_release();
        if (instance.isVirtual) {
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui_release(owner);
        }
        if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
        }
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui_release(int index, int count) {
        if (count >= 0) {
            int i = (index + count) - 1;
            if (index > i) {
                return;
            }
            while (true) {
                LayoutNode child = this._foldedChildren.removeAt(i);
                onChildRemoved(child);
                if (i == index) {
                    return;
                } else {
                    i--;
                }
            }
        } else {
            throw new IllegalArgumentException(("count (" + count + ") must be greater than 0").toString());
        }
    }

    public final void removeAll$ui_release() {
        int i = this._foldedChildren.getSize();
        while (true) {
            i--;
            if (-1 < i) {
                onChildRemoved(this._foldedChildren.get(i));
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode child) {
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(r0.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            child.detach$ui_release();
        }
        child._foldedParent = null;
        child.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVectorWithMutationTracking this_$iv = child._foldedChildren;
            MutableVector this_$iv$iv = this_$iv.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    it.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    public final void move$ui_release(int from, int to, int count) {
        if (from == to) {
            return;
        }
        for (int i = 0; i < count; i++) {
            int fromIndex = from > to ? from + i : from;
            int toIndex = from > to ? to + i : (to + count) - 2;
            LayoutNode child = this._foldedChildren.removeAt(fromIndex);
            this._foldedChildren.add(toIndex, child);
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    public final void invalidateSemantics$ui_release() {
        this._collapsedSemantics = null;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        if (!this.nodes.m4363hasH91voCI$ui_release(NodeKind.m4400constructorimpl(8)) || this._collapsedSemantics != null) {
            return this._collapsedSemantics;
        }
        final Ref.ObjectRef config = new Ref.ObjectRef();
        config.element = new SemanticsConfiguration();
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1
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

            /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int mask$iv$iv;
                boolean z;
                Ref.ObjectRef<SemanticsConfiguration> objectRef;
                int type$iv;
                int type$iv2;
                DelegatingNode this_$iv$iv$iv;
                int $i$f$forEachImmediateDelegate$ui_release;
                int count$iv$iv;
                MutableVector mutableVector;
                NodeChain this_$iv = LayoutNode.this.getNodes();
                int type$iv3 = NodeKind.m4400constructorimpl(8);
                Ref.ObjectRef<SemanticsConfiguration> objectRef2 = config;
                int i = 0;
                int mask$iv$iv2 = type$iv3;
                if ((this_$iv.getAggregateChildKindSet() & mask$iv$iv2) == 0) {
                    return;
                }
                Modifier.Node node$iv$iv$iv = this_$iv.getTail();
                while (node$iv$iv$iv != null) {
                    Modifier.Node it$iv$iv = node$iv$iv$iv;
                    if ((it$iv$iv.getKindSet() & mask$iv$iv2) != 0) {
                        MutableVector mutableVector2 = null;
                        Modifier.Node this_$iv$iv$iv2 = it$iv$iv;
                        while (this_$iv$iv$iv2 != null) {
                            NodeChain this_$iv2 = this_$iv;
                            int i2 = i;
                            if (this_$iv$iv$iv2 instanceof SemanticsModifierNode) {
                                SemanticsModifierNode it = (SemanticsModifierNode) this_$iv$iv$iv2;
                                if (!it.getIsClearingSemantics()) {
                                    mask$iv$iv = mask$iv$iv2;
                                    z = true;
                                } else {
                                    objectRef2.element = new SemanticsConfiguration();
                                    mask$iv$iv = mask$iv$iv2;
                                    z = true;
                                    objectRef2.element.setClearingSemantics(true);
                                }
                                if (it.getShouldMergeDescendantSemantics()) {
                                    objectRef2.element.setMergingSemanticsOfDescendants(z);
                                }
                                SemanticsConfiguration $this$invoke_u24lambda_u242_u24lambda_u241 = objectRef2.element;
                                objectRef = objectRef2;
                                it.applySemantics($this$invoke_u24lambda_u242_u24lambda_u241);
                                type$iv = type$iv3;
                            } else {
                                objectRef = objectRef2;
                                mask$iv$iv = mask$iv$iv2;
                                if (!((this_$iv$iv$iv2.getKindSet() & type$iv3) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                    type$iv = type$iv3;
                                } else {
                                    int count$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) this_$iv$iv$iv2;
                                    int $i$f$forEachImmediateDelegate$ui_release2 = 0;
                                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv3.getDelegate();
                                    while (node$iv$iv$iv2 != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                        if (!((next$iv$iv.getKindSet() & type$iv3) != 0)) {
                                            type$iv2 = type$iv3;
                                            this_$iv$iv$iv = this_$iv$iv$iv3;
                                            $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                        } else {
                                            count$iv$iv2++;
                                            if (count$iv$iv2 == 1) {
                                                this_$iv$iv$iv2 = next$iv$iv;
                                                type$iv2 = type$iv3;
                                                this_$iv$iv$iv = this_$iv$iv$iv3;
                                                $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                            } else {
                                                if (mutableVector2 != null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv2 = type$iv3;
                                                    this_$iv$iv$iv = this_$iv$iv$iv3;
                                                    $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                    mutableVector = mutableVector2;
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    type$iv2 = type$iv3;
                                                    this_$iv$iv$iv = this_$iv$iv$iv3;
                                                    $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                MutableVector mutableVector3 = mutableVector;
                                                Modifier.Node theNode$iv$iv = this_$iv$iv$iv2;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(theNode$iv$iv);
                                                    }
                                                    this_$iv$iv$iv2 = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv);
                                                }
                                                mutableVector2 = mutableVector3;
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        }
                                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                        type$iv3 = type$iv2;
                                        this_$iv$iv$iv3 = this_$iv$iv$iv;
                                        $i$f$forEachImmediateDelegate$ui_release2 = $i$f$forEachImmediateDelegate$ui_release;
                                    }
                                    type$iv = type$iv3;
                                    if (count$iv$iv2 == 1) {
                                        this_$iv = this_$iv2;
                                        i = i2;
                                        mask$iv$iv2 = mask$iv$iv;
                                        objectRef2 = objectRef;
                                        type$iv3 = type$iv;
                                    }
                                }
                            }
                            this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector2);
                            this_$iv = this_$iv2;
                            i = i2;
                            mask$iv$iv2 = mask$iv$iv;
                            objectRef2 = objectRef;
                            type$iv3 = type$iv;
                        }
                    }
                    node$iv$iv$iv = node$iv$iv$iv.getParent();
                    this_$iv = this_$iv;
                    i = i;
                    mask$iv$iv2 = mask$iv$iv2;
                    objectRef2 = objectRef2;
                    type$iv3 = type$iv3;
                }
            }
        });
        this._collapsedSemantics = (SemanticsConfiguration) config.element;
        return (SemanticsConfiguration) config.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void attach$ui_release(androidx.compose.ui.node.Owner r12) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    public final void detach$ui_release() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder append = new StringBuilder().append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            throw new IllegalStateException(append.append(parent$ui_release != null ? debugTreeToString$default(parent$ui_release, 0, 1, null) : null).toString().toString());
        }
        invalidateFocusOnDetach();
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
            parent.invalidateMeasurements$ui_release();
            getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(UsageByParent.NotUsed);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate it = getLookaheadPassDelegate$ui_release();
            if (it != null) {
                it.setMeasuredByParent$ui_release(UsageByParent.NotUsed);
            }
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        if (this.nodes.m4363hasH91voCI$ui_release(NodeKind.m4400constructorimpl(8))) {
            invalidateSemantics$ui_release();
        }
        this.nodes.runDetachLifecycle$ui_release();
        this.ignoreRemeasureRequests = true;
        MutableVector this_$iv$iv = this._foldedChildren.getVector();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                child.detach$ui_release();
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        this.ignoreRemeasureRequests = false;
        this.nodes.markAsDetached$ui_release();
        owner.onDetach(this);
        this.owner = null;
        setLookaheadRoot(null);
        this.depth = 0;
        getMeasurePassDelegate$ui_release().onNodeDetached();
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            lookaheadPassDelegate$ui_release.onNodeDetached();
        }
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector this_$iv = this._zSortedChildren;
            MutableVector elements$iv = get_children$ui_release();
            this_$iv.addAll(this_$iv.getSize(), elements$iv);
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long innerContentConstraints = getInnerCoordinator$ui_release().m4384getLastMeasurementConstraintsmsEJaDk$ui_release();
        return Constraints.m5172getHasFixedWidthimpl(innerContentConstraints) && Constraints.m5171getHasFixedHeightimpl(innerContentConstraints);
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int depth) {
        StringBuilder tree = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            tree.append("  ");
        }
        tree.append("|-");
        tree.append(toString());
        tree.append('\n');
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                tree.append(child.debugTreeToString(depth + 1));
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        String treeString = tree.toString();
        Intrinsics.checkNotNullExpressionValue(treeString, "tree.toString()");
        if (depth == 0) {
            String treeString2 = treeString.substring(0, treeString.length() - 1);
            Intrinsics.checkNotNullExpressionValue(treeString2, "this as java.lang.String…ing(startIndex, endIndex)");
            return treeString2;
        }
        return treeString;
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List measurables, int width) {
            return ((Number) m4331maxIntrinsicHeight($this$maxIntrinsicHeight, (List<? extends IntrinsicMeasurable>) measurables, width)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List measurables, int height) {
            return ((Number) m4332maxIntrinsicWidth($this$maxIntrinsicWidth, (List<? extends IntrinsicMeasurable>) measurables, height)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List measurables, int width) {
            return ((Number) m4333minIntrinsicHeight($this$minIntrinsicHeight, (List<? extends IntrinsicMeasurable>) measurables, width)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List measurables, int height) {
            return ((Number) m4334minIntrinsicWidth($this$minIntrinsicWidth, (List<? extends IntrinsicMeasurable>) measurables, height)).intValue();
        }

        /* renamed from: minIntrinsicWidth */
        public Void m4334minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: minIntrinsicHeight */
        public Void m4333minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: maxIntrinsicWidth */
        public Void m4332maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: maxIntrinsicHeight */
        public Void m4331maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(MeasurePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.measurePolicy, value)) {
            this.measurePolicy = value;
            this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
            invalidateMeasurements$ui_release();
        }
    }

    /* renamed from: getIntrinsicsPolicy$ui_release, reason: from getter */
    public final IntrinsicsPolicy getIntrinsicsPolicy() {
        return this.intrinsicsPolicy;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(Density value) {
        NodeChain this_$iv;
        int type$iv;
        int i;
        NodeChain this_$iv2;
        int type$iv2;
        int i2;
        NodeChain this_$iv3;
        int type$iv3;
        int i3;
        int count$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.density, value)) {
            this.density = value;
            onDensityOrLayoutDirectionChanged();
            NodeChain this_$iv4 = this.nodes;
            int type$iv4 = NodeKind.m4400constructorimpl(16);
            int i4 = 0;
            if ((this_$iv4.getAggregateChildKindSet() & type$iv4) == 0) {
                return;
            }
            Modifier.Node node$iv$iv$iv = this_$iv4.getHead();
            while (node$iv$iv$iv != null) {
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet() & type$iv4) == 0) {
                    this_$iv = this_$iv4;
                    type$iv = type$iv4;
                    i = i4;
                } else {
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv$iv;
                    while (node != null) {
                        if (node instanceof PointerInputModifierNode) {
                            PointerInputModifierNode it = (PointerInputModifierNode) node;
                            it.onDensityChange();
                            this_$iv2 = this_$iv4;
                            type$iv2 = type$iv4;
                            i2 = i4;
                        } else {
                            Modifier.Node this_$iv$iv$iv = node;
                            if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                this_$iv2 = this_$iv4;
                                type$iv2 = type$iv4;
                                i2 = i4;
                            } else {
                                int count$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if (!((next$iv$iv.getKindSet() & type$iv4) != 0)) {
                                        this_$iv3 = this_$iv4;
                                        type$iv3 = type$iv4;
                                        i3 = i4;
                                    } else {
                                        count$iv$iv2++;
                                        this_$iv3 = this_$iv4;
                                        if (count$iv$iv2 == 1) {
                                            node = next$iv$iv;
                                            type$iv3 = type$iv4;
                                            i3 = i4;
                                        } else {
                                            if (mutableVector2 != null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
                                                i3 = i4;
                                                mutableVector = mutableVector2;
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
                                                i3 = i4;
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
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                    this_$iv4 = this_$iv3;
                                    type$iv4 = type$iv3;
                                    i4 = i3;
                                }
                                this_$iv2 = this_$iv4;
                                type$iv2 = type$iv4;
                                i2 = i4;
                                if (count$iv$iv2 == 1) {
                                    this_$iv4 = this_$iv2;
                                    type$iv4 = type$iv2;
                                    i4 = i2;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        this_$iv4 = this_$iv2;
                        type$iv4 = type$iv2;
                        i4 = i2;
                    }
                    this_$iv = this_$iv4;
                    type$iv = type$iv4;
                    i = i4;
                }
                if ((it$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                    return;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild();
                this_$iv4 = this_$iv;
                type$iv4 = type$iv;
                i4 = i;
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(LayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(ViewConfiguration value) {
        NodeChain this_$iv;
        int type$iv;
        int i;
        NodeChain this_$iv2;
        int type$iv2;
        int i2;
        NodeChain this_$iv3;
        int type$iv3;
        int i3;
        int count$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.viewConfiguration, value)) {
            this.viewConfiguration = value;
            NodeChain this_$iv4 = this.nodes;
            int type$iv4 = NodeKind.m4400constructorimpl(16);
            int i4 = 0;
            if ((this_$iv4.getAggregateChildKindSet() & type$iv4) == 0) {
                return;
            }
            Modifier.Node node$iv$iv$iv = this_$iv4.getHead();
            while (node$iv$iv$iv != null) {
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet() & type$iv4) == 0) {
                    this_$iv = this_$iv4;
                    type$iv = type$iv4;
                    i = i4;
                } else {
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv$iv;
                    while (node != null) {
                        if (node instanceof PointerInputModifierNode) {
                            PointerInputModifierNode it = (PointerInputModifierNode) node;
                            it.onViewConfigurationChange();
                            this_$iv2 = this_$iv4;
                            type$iv2 = type$iv4;
                            i2 = i4;
                        } else {
                            Modifier.Node this_$iv$iv$iv = node;
                            if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                this_$iv2 = this_$iv4;
                                type$iv2 = type$iv4;
                                i2 = i4;
                            } else {
                                int count$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if (!((next$iv$iv.getKindSet() & type$iv4) != 0)) {
                                        this_$iv3 = this_$iv4;
                                        type$iv3 = type$iv4;
                                        i3 = i4;
                                    } else {
                                        count$iv$iv2++;
                                        this_$iv3 = this_$iv4;
                                        if (count$iv$iv2 == 1) {
                                            node = next$iv$iv;
                                            type$iv3 = type$iv4;
                                            i3 = i4;
                                        } else {
                                            if (mutableVector2 != null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
                                                i3 = i4;
                                                mutableVector = mutableVector2;
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
                                                i3 = i4;
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
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                    this_$iv4 = this_$iv3;
                                    type$iv4 = type$iv3;
                                    i4 = i3;
                                }
                                this_$iv2 = this_$iv4;
                                type$iv2 = type$iv4;
                                i2 = i4;
                                if (count$iv$iv2 == 1) {
                                    this_$iv4 = this_$iv2;
                                    type$iv4 = type$iv2;
                                    i4 = i2;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        this_$iv4 = this_$iv2;
                        type$iv4 = type$iv2;
                        i4 = i2;
                    }
                    this_$iv = this_$iv4;
                    type$iv = type$iv4;
                    i = i4;
                }
                if ((it$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                    return;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild();
                this_$iv4 = this_$iv;
                type$iv4 = type$iv;
                i4 = i;
            }
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositionLocalMap(CompositionLocalMap value) {
        NodeChain this_$iv;
        int type$iv;
        int type$iv2;
        int type$iv3;
        int count$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(value, "value");
        this.compositionLocalMap = value;
        setDensity((Density) value.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) value.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) value.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain this_$iv2 = this.nodes;
        int type$iv4 = NodeKind.m4400constructorimpl(32768);
        if ((this_$iv2.getAggregateChildKindSet() & type$iv4) == 0) {
            return;
        }
        Modifier.Node node$iv$iv$iv = this_$iv2.getHead();
        while (node$iv$iv$iv != null) {
            Modifier.Node it$iv$iv = node$iv$iv$iv;
            if ((it$iv$iv.getKindSet() & type$iv4) == 0) {
                this_$iv = this_$iv2;
                type$iv = type$iv4;
            } else {
                MutableVector mutableVector2 = null;
                Modifier.Node node = it$iv$iv;
                while (node != null) {
                    NodeChain this_$iv3 = this_$iv2;
                    if (node instanceof CompositionLocalConsumerModifierNode) {
                        CompositionLocalConsumerModifierNode modifierNode = (CompositionLocalConsumerModifierNode) node;
                        Modifier.Node delegatedNode = modifierNode.getNode();
                        if (delegatedNode.getIsAttached()) {
                            NodeKindKt.autoInvalidateUpdatedNode(delegatedNode);
                        } else {
                            delegatedNode.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                        }
                        type$iv2 = type$iv4;
                    } else {
                        Modifier.Node this_$iv$iv$iv = node;
                        if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                            type$iv2 = type$iv4;
                        } else {
                            int count$iv$iv2 = 0;
                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                            Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                            while (node$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                if (!((next$iv$iv.getKindSet() & type$iv4) != 0)) {
                                    type$iv3 = type$iv4;
                                } else {
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == 1) {
                                        node = next$iv$iv;
                                        type$iv3 = type$iv4;
                                    } else {
                                        if (mutableVector2 != null) {
                                            count$iv$iv = count$iv$iv2;
                                            type$iv3 = type$iv4;
                                            mutableVector = mutableVector2;
                                        } else {
                                            count$iv$iv = count$iv$iv2;
                                            type$iv3 = type$iv4;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
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
                                        count$iv$iv2 = count$iv$iv;
                                    }
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                type$iv4 = type$iv3;
                            }
                            type$iv2 = type$iv4;
                            if (count$iv$iv2 == 1) {
                                this_$iv2 = this_$iv3;
                                type$iv4 = type$iv2;
                            }
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector2);
                    this_$iv2 = this_$iv3;
                    type$iv4 = type$iv2;
                }
                this_$iv = this_$iv2;
                type$iv = type$iv4;
            }
            if ((it$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                return;
            }
            node$iv$iv$iv = node$iv$iv$iv.getChild();
            this_$iv2 = this_$iv;
            type$iv4 = type$iv;
        }
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate $this$_get_alignmentLinesRequired__u24lambda_u2420 = this.layoutDelegate;
        if ($this$_get_alignmentLinesRequired__u24lambda_u2420.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = $this$_get_alignmentLinesRequired__u24lambda_u2420.getLookaheadAlignmentLinesOwner$ui_release();
        return lookaheadAlignmentLinesOwner$ui_release != null && (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) != null && alignmentLines.getRequired$ui_release();
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        UsageByParent measuredByParent$ui_release;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        return (lookaheadPassDelegate$ui_release == null || (measuredByParent$ui_release = lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release()) == null) ? UsageByParent.NotUsed : measuredByParent$ui_release;
    }

    /* renamed from: getIntrinsicsUsageByParent$ui_release, reason: from getter */
    public final UsageByParent getIntrinsicsUsageByParent() {
        return this.intrinsicsUsageByParent;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    /* renamed from: getCanMultiMeasure$ui_release, reason: from getter */
    public final boolean getCanMultiMeasure() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    /* renamed from: getNodes$ui_release, reason: from getter */
    public final NodeChain getNodes() {
        return this.nodes;
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator();
    }

    /* renamed from: getLayoutDelegate$ui_release, reason: from getter */
    public final LayoutNodeLayoutDelegate getLayoutDelegate() {
        return this.layoutDelegate;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator();
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    /* renamed from: getSubcompositionsState$ui_release, reason: from getter */
    public final LayoutNodeSubcompositionsState getSubcompositionsState() {
        return this.subcompositionsState;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    /* renamed from: getInnerLayerCoordinatorIsDirty$ui_release, reason: from getter */
    public final boolean getInnerLayerCoordinatorIsDirty() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator coordinator = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy = getOuterCoordinator$ui_release().getWrappedBy();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(coordinator, wrappedBy)) {
                    break;
                }
                if ((coordinator != null ? coordinator.getLayer() : null) != null) {
                    this._innerLayerCoordinator = coordinator;
                    break;
                }
                coordinator = coordinator != null ? coordinator.getWrappedBy() : null;
            }
        }
        NodeCoordinator coordinator2 = this._innerLayerCoordinator;
        if (coordinator2 == null || coordinator2.getLayer() != null) {
            return coordinator2;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!(!this.isVirtual || getModifier() == Modifier.INSTANCE)) {
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
        this.modifier = value;
        this.nodes.updateFrom$ui_release(value);
        this.layoutDelegate.updateParentData();
        if (this.nodes.m4363hasH91voCI$ui_release(NodeKind.m4400constructorimpl(512)) && this.lookaheadRoot == null) {
            setLookaheadRoot(this);
        }
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    /* renamed from: getNeedsOnPositionedDispatch$ui_release, reason: from getter */
    public final boolean getNeedsOnPositionedDispatch() {
        return this.needsOnPositionedDispatch;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void place$ui_release(int x, int y) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate $this$place_u24lambda_u2423 = getMeasurePassDelegate$ui_release();
        Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.INSTANCE;
        int parentWidth$iv = $this$place_u24lambda_u2423.getMeasuredWidth();
        LayoutDirection parentLayoutDirection$iv = getLayoutDirection();
        LayoutNode parent$ui_release = getParent$ui_release();
        LookaheadCapablePlaceable lookaheadCapablePlaceable$iv = parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null;
        LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
        int previousParentWidth$iv = Placeable.PlacementScope.INSTANCE.getParentWidth();
        LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.INSTANCE.getParentLayoutDirection();
        LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentWidth = parentWidth$iv;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
        boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(lookaheadCapablePlaceable$iv);
        Placeable.PlacementScope.Companion $this$place_u24lambda_u2423_u24lambda_u2422 = this_$iv;
        Placeable.PlacementScope.placeRelative$default($this$place_u24lambda_u2423_u24lambda_u2422, $this$place_u24lambda_u2423, x, y, 0.0f, 4, null);
        if (lookaheadCapablePlaceable$iv != null) {
            lookaheadCapablePlaceable$iv.setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
        }
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
        Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
        Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui_release().replace();
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.replace();
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterCoordinator$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default */
    public static /* synthetic */ void m4321hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) == 0) {
            z3 = z;
        } else {
            z3 = false;
        }
        if ((i & 8) == 0) {
            z4 = z2;
        } else {
            z4 = true;
        }
        layoutNode.m4325hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release */
    public final void m4325hitTestM_7yMNQ$ui_release(long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        long positionInWrapped = getOuterCoordinator$ui_release().m4383fromParentPositionMKHz9U(pointerPosition);
        getOuterCoordinator$ui_release().m4387hitTestYqVAtuI(NodeCoordinator.INSTANCE.getPointerInputSource(), positionInWrapped, hitTestResult, isTouchEvent, isInLayer);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release$default */
    public static /* synthetic */ void m4322hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) == 0) {
            z3 = z;
        } else {
            z3 = true;
        }
        if ((i & 8) == 0) {
            z4 = z2;
        } else {
            z4 = true;
        }
        layoutNode.m4326hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release */
    public final void m4326hitTestSemanticsM_7yMNQ$ui_release(long pointerPosition, HitTestResult hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitSemanticsEntities, "hitSemanticsEntities");
        long positionInWrapped = getOuterCoordinator$ui_release().m4383fromParentPositionMKHz9U(pointerPosition);
        getOuterCoordinator$ui_release().m4387hitTestYqVAtuI(NodeCoordinator.INSTANCE.getSemanticsSource(), positionInWrapped, hitSemanticsEntities, true, isInLayer);
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] == 1) {
            if (it.getMeasurePending$ui_release()) {
                requestRemeasure$ui_release$default(it, true, false, 2, null);
                return;
            }
            if (it.getLayoutPending$ui_release()) {
                it.requestRelayout$ui_release(true);
                return;
            } else if (it.getLookaheadMeasurePending$ui_release()) {
                requestLookaheadRemeasure$ui_release$default(it, true, false, 2, null);
                return;
            } else {
                if (it.getLookaheadLayoutPending$ui_release()) {
                    it.requestLookaheadRelayout$ui_release(true);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui_release());
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestRemeasure$ui_release(z, z2);
    }

    public final void requestRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestMeasure$default(owner, this, false, forceRequest, scheduleMeasureAndLayout, 2, null);
        getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(forceRequest);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z, z2);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (!(this.lookaheadRoot != null)) {
            throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
        }
        Owner owner = this.owner;
        if (owner != null && !this.ignoreRemeasureRequests && !this.isVirtual) {
            owner.onRequestMeasure(this, true, forceRequest, scheduleMeasureAndLayout);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.invalidateIntrinsicsParent(forceRequest);
        }
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 3, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 3, null);
        }
    }

    private final void invalidateFocusOnAttach() {
        NodeChain nodeChain = this.nodes;
        int $this$or_u2d64DMado$iv = NodeKind.m4400constructorimpl(1024) | NodeKind.m4400constructorimpl(2048);
        if (nodeChain.has$ui_release($this$or_u2d64DMado$iv | NodeKind.m4400constructorimpl(4096))) {
            NodeChain this_$iv = this.nodes;
            for (Modifier.Node node$iv = this_$iv.getHead(); node$iv != null; node$iv = node$iv.getChild()) {
                Modifier.Node it = node$iv;
                int kind$iv = (it.getKindSet() & NodeKind.m4400constructorimpl(1024)) != 0 ? 1 : 0;
                int kind$iv2 = (it.getKindSet() & NodeKind.m4400constructorimpl(2048)) != 0 ? 1 : 0;
                if ((kind$iv | kind$iv2 | ((it.getKindSet() & NodeKind.m4400constructorimpl(4096)) == 0 ? 0 : 1)) != 0) {
                    NodeKindKt.autoInvalidateInsertedNode(it);
                }
            }
        }
    }

    private final void invalidateFocusOnDetach() {
        int mask$iv$iv;
        NodeChain this_$iv$iv;
        int type$iv;
        int type$iv2;
        int count$iv$iv;
        MutableVector mutableVector;
        NodeChain this_$iv = this.nodes;
        int type$iv3 = NodeKind.m4400constructorimpl(1024);
        int i = 0;
        int mask$iv$iv2 = type$iv3;
        NodeChain this_$iv$iv2 = this_$iv;
        if ((this_$iv$iv2.getAggregateChildKindSet() & mask$iv$iv2) == 0) {
            return;
        }
        Modifier.Node node$iv$iv$iv = this_$iv$iv2.getTail();
        while (node$iv$iv$iv != null) {
            Modifier.Node it$iv$iv = node$iv$iv$iv;
            if ((it$iv$iv.getKindSet() & mask$iv$iv2) != 0) {
                MutableVector mutableVector2 = null;
                Modifier.Node node = it$iv$iv;
                while (node != null) {
                    NodeChain this_$iv2 = this_$iv;
                    int i2 = i;
                    int i3 = 1;
                    if (node instanceof FocusTargetNode) {
                        FocusTargetNode it = (FocusTargetNode) node;
                        if (!it.getFocusState().isFocused()) {
                            mask$iv$iv = mask$iv$iv2;
                            this_$iv$iv = this_$iv$iv2;
                        } else {
                            mask$iv$iv = mask$iv$iv2;
                            this_$iv$iv = this_$iv$iv2;
                            LayoutNodeKt.requireOwner(this).getFocusOwner().clearFocus(true, false);
                            it.scheduleInvalidationForFocusEvents$ui_release();
                        }
                        type$iv = type$iv3;
                    } else {
                        mask$iv$iv = mask$iv$iv2;
                        this_$iv$iv = this_$iv$iv2;
                        Modifier.Node this_$iv$iv$iv = node;
                        if (!((this_$iv$iv$iv.getKindSet() & type$iv3) != 0) || !(node instanceof DelegatingNode)) {
                            type$iv = type$iv3;
                        } else {
                            int count$iv$iv2 = 0;
                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                            Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                            while (node$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                if (((next$iv$iv.getKindSet() & type$iv3) != 0 ? i3 : 0) == 0) {
                                    type$iv2 = type$iv3;
                                } else {
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i3) {
                                        node = next$iv$iv;
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
                                        count$iv$iv2 = count$iv$iv;
                                    }
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                type$iv3 = type$iv2;
                                i3 = 1;
                            }
                            type$iv = type$iv3;
                            if (count$iv$iv2 == 1) {
                                this_$iv = this_$iv2;
                                i = i2;
                                this_$iv$iv2 = this_$iv$iv;
                                mask$iv$iv2 = mask$iv$iv;
                                type$iv3 = type$iv;
                            }
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector2);
                    this_$iv = this_$iv2;
                    i = i2;
                    this_$iv$iv2 = this_$iv$iv;
                    mask$iv$iv2 = mask$iv$iv;
                    type$iv3 = type$iv;
                }
            }
            node$iv$iv$iv = node$iv$iv$iv.getParent();
            this_$iv = this_$iv;
            i = i;
            this_$iv$iv2 = this_$iv$iv2;
            mask$iv$iv2 = mask$iv$iv2;
            type$iv3 = type$iv3;
        }
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public final void requestRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestRelayout$default(owner, this, false, forceRequest, 2, null);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public final void requestLookaheadRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, true, forceRequest);
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        NodeChain this_$iv;
        int type$iv;
        char c;
        int i;
        NodeChain this_$iv2;
        int i2;
        int type$iv2;
        int type$iv3;
        int count$iv$iv;
        MutableVector mutableVector;
        if (getLayoutState$ui_release() != LayoutState.Idle || getLayoutPending$ui_release() || getMeasurePending$ui_release() || !isPlaced()) {
            return;
        }
        NodeChain this_$iv3 = this.nodes;
        char c2 = 256;
        int type$iv4 = NodeKind.m4400constructorimpl(256);
        int i3 = 0;
        if ((this_$iv3.getAggregateChildKindSet() & type$iv4) == 0) {
            return;
        }
        Modifier.Node node$iv$iv$iv = this_$iv3.getHead();
        while (node$iv$iv$iv != null) {
            Modifier.Node it$iv$iv = node$iv$iv$iv;
            if ((it$iv$iv.getKindSet() & type$iv4) == 0) {
                this_$iv = this_$iv3;
                type$iv = type$iv4;
                c = c2;
                i = i3;
            } else {
                MutableVector mutableVector2 = null;
                Modifier.Node node = it$iv$iv;
                while (node != null) {
                    if (node instanceof GlobalPositionAwareModifierNode) {
                        GlobalPositionAwareModifierNode it = (GlobalPositionAwareModifierNode) node;
                        this_$iv2 = this_$iv3;
                        i2 = i3;
                        it.onGloballyPositioned(DelegatableNodeKt.m4299requireCoordinator64DMado(it, NodeKind.m4400constructorimpl(256)));
                        type$iv2 = type$iv4;
                    } else {
                        this_$iv2 = this_$iv3;
                        i2 = i3;
                        Modifier.Node this_$iv$iv$iv = node;
                        int kindSet = this_$iv$iv$iv.getKindSet() & type$iv4;
                        int i4 = 1;
                        if ((kindSet != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                            type$iv2 = type$iv4;
                        } else {
                            int count$iv$iv2 = 0;
                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                            Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                            while (node$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                if (((next$iv$iv.getKindSet() & type$iv4) != 0 ? i4 : 0) == 0) {
                                    type$iv3 = type$iv4;
                                } else {
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i4) {
                                        node = next$iv$iv;
                                        type$iv3 = type$iv4;
                                    } else {
                                        if (mutableVector2 != null) {
                                            count$iv$iv = count$iv$iv2;
                                            type$iv3 = type$iv4;
                                            mutableVector = mutableVector2;
                                        } else {
                                            count$iv$iv = count$iv$iv2;
                                            type$iv3 = type$iv4;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
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
                                        count$iv$iv2 = count$iv$iv;
                                    }
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                type$iv4 = type$iv3;
                                i4 = 1;
                            }
                            type$iv2 = type$iv4;
                            if (count$iv$iv2 == 1) {
                                this_$iv3 = this_$iv2;
                                i3 = i2;
                                type$iv4 = type$iv2;
                            }
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector2);
                    this_$iv3 = this_$iv2;
                    i3 = i2;
                    type$iv4 = type$iv2;
                }
                this_$iv = this_$iv3;
                type$iv = type$iv4;
                i = i3;
                c = 256;
            }
            if ((it$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                return;
            }
            node$iv$iv$iv = node$iv$iv$iv.getChild();
            c2 = c;
            this_$iv3 = this_$iv;
            i3 = i;
            type$iv4 = type$iv;
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator inner$iv = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator$iv = getOuterCoordinator$ui_release(); coordinator$iv != inner$iv; coordinator$iv = ((LayoutModifierNodeCoordinator) coordinator$iv).getWrapped()) {
            Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator coordinator = (LayoutModifierNodeCoordinator) coordinator$iv;
            OwnedLayer layer = coordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default */
    public static /* synthetic */ boolean m4323lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m4342getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m4327lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release */
    public final boolean m4327lookaheadRemeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints != null && this.lookaheadRoot != null) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            return lookaheadPassDelegate$ui_release.m4345remeasureBRTryo0(constraints.getValue());
        }
        return false;
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default */
    public static /* synthetic */ boolean m4324remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m4341getLastConstraintsDWUhwKw();
        }
        return layoutNode.m4328remeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release */
    public final boolean m4328remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints != null) {
            if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
                clearSubtreeIntrinsicsUsage$ui_release();
            }
            return getMeasurePassDelegate$ui_release().m4348remeasureBRTryo0(constraints.getValue());
        }
        return false;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    public final void invalidateSubtree(boolean isRootOfInvalidation) {
        NodeChain this_$iv;
        int type$iv;
        char c;
        char c2;
        NodeChain this_$iv2;
        int type$iv2;
        NodeChain this_$iv3;
        int type$iv3;
        int count$iv$iv;
        MutableVector mutableVector;
        LayoutNode parent$ui_release;
        if (isRootOfInvalidation && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateSemantics$ui_release();
        requestRemeasure$ui_release$default(this, false, false, 3, null);
        NodeChain this_$iv4 = this.nodes;
        char c3 = 2;
        int type$iv4 = NodeKind.m4400constructorimpl(2);
        if ((this_$iv4.getAggregateChildKindSet() & type$iv4) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv4.getHead();
            while (node$iv$iv$iv != null) {
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet() & type$iv4) == 0) {
                    this_$iv = this_$iv4;
                    type$iv = type$iv4;
                    c = c3;
                } else {
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv$iv;
                    while (node != null) {
                        if (node instanceof LayoutModifierNode) {
                            LayoutModifierNode it = (LayoutModifierNode) node;
                            c2 = 2;
                            OwnedLayer layer = DelegatableNodeKt.m4299requireCoordinator64DMado(it, NodeKind.m4400constructorimpl(2)).getLayer();
                            if (layer != null) {
                                layer.invalidate();
                            }
                            this_$iv2 = this_$iv4;
                            type$iv2 = type$iv4;
                        } else {
                            c2 = c3;
                            Modifier.Node this_$iv$iv$iv = node;
                            if (!((this_$iv$iv$iv.getKindSet() & type$iv4) != 0) || !(node instanceof DelegatingNode)) {
                                this_$iv2 = this_$iv4;
                                type$iv2 = type$iv4;
                            } else {
                                int count$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if (!((next$iv$iv.getKindSet() & type$iv4) != 0)) {
                                        this_$iv3 = this_$iv4;
                                        type$iv3 = type$iv4;
                                    } else {
                                        count$iv$iv2++;
                                        this_$iv3 = this_$iv4;
                                        if (count$iv$iv2 == 1) {
                                            node = next$iv$iv;
                                            type$iv3 = type$iv4;
                                        } else {
                                            if (mutableVector2 != null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
                                                mutableVector = mutableVector2;
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv4;
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
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                    this_$iv4 = this_$iv3;
                                    type$iv4 = type$iv3;
                                }
                                this_$iv2 = this_$iv4;
                                type$iv2 = type$iv4;
                                if (count$iv$iv2 == 1) {
                                    c3 = c2;
                                    this_$iv4 = this_$iv2;
                                    type$iv4 = type$iv2;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        c3 = c2;
                        this_$iv4 = this_$iv2;
                        type$iv4 = type$iv2;
                    }
                    this_$iv = this_$iv4;
                    type$iv = type$iv4;
                    c = c3;
                }
                if ((it$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                    break;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild();
                c3 = c;
                this_$iv4 = this_$iv;
                type$iv4 = type$iv;
            }
        }
        MutableVector this_$iv5 = get_children$ui_release();
        int size$iv = this_$iv5.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv5.getContent();
        do {
            LayoutNode it2 = (LayoutNode) content$iv[i$iv];
            it2.invalidateSubtree(false);
            i$iv++;
        } while (i$iv < size$iv);
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 1, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 1, null);
        }
        Constraints lastConstraints = this.layoutDelegate.m4341getLastConstraintsDWUhwKw();
        if (lastConstraints != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.mo4455measureAndLayout0kLqBqw(this, lastConstraints.getValue());
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            Owner.measureAndLayout$default(owner2, false, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator this_$iv;
        int type$iv;
        int i;
        NodeCoordinator this_$iv2;
        int type$iv2;
        int i2;
        int type$iv3;
        int i3;
        MutableVector mutableVector;
        NodeCoordinator this_$iv3 = getInnerCoordinator$ui_release();
        int type$iv4 = NodeKind.m4400constructorimpl(128);
        int i4 = 0;
        boolean includeTail$iv$iv = NodeKindKt.m4409getIncludeSelfInTraversalH91voCI(type$iv4);
        Modifier.Node stopNode$iv$iv = this_$iv3.getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent()) != null) {
            Modifier.Node node$iv$iv = this_$iv3.headNode(includeTail$iv$iv);
            while (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet() & type$iv4) != 0) {
                if ((node$iv$iv.getKindSet() & type$iv4) == 0) {
                    this_$iv = this_$iv3;
                    type$iv = type$iv4;
                    i = i4;
                } else {
                    Modifier.Node it$iv = node$iv$iv;
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv;
                    while (node != null) {
                        if (node instanceof LayoutAwareModifierNode) {
                            LayoutAwareModifierNode it = (LayoutAwareModifierNode) node;
                            this_$iv2 = this_$iv3;
                            it.onPlaced(getInnerCoordinator$ui_release());
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
                    this_$iv = this_$iv3;
                    type$iv = type$iv4;
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

    public final void forEachCoordinator$ui_release(Function1<? super LayoutModifierNodeCoordinator, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NodeCoordinator inner = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator = getOuterCoordinator$ui_release(); coordinator != inner; coordinator = ((LayoutModifierNodeCoordinator) coordinator).getWrapped()) {
            Intrinsics.checkNotNull(coordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            block.invoke((LayoutModifierNodeCoordinator) coordinator);
        }
    }

    public final void forEachCoordinatorIncludingInner$ui_release(Function1<? super NodeCoordinator, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator delegate = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate, wrapped) && delegate != null; delegate = delegate.getWrapped()) {
            block.invoke(delegate);
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        if (this.nodes.m4363hasH91voCI$ui_release(NodeKind.m4400constructorimpl(4)) && !this.nodes.m4363hasH91voCI$ui_release(NodeKind.m4400constructorimpl(2))) {
            return true;
        }
        NodeChain this_$iv = this.nodes;
        for (Modifier.Node node$iv = this_$iv.getHead(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            int kind$iv = (it.getKindSet() & NodeKind.m4400constructorimpl(2)) != 0 ? 1 : 0;
            if (kind$iv != 0 && DelegatableNodeKt.m4299requireCoordinator64DMado(it, NodeKind.m4400constructorimpl(2)).getLayer() != null) {
                return false;
            }
            if ((it.getKindSet() & NodeKind.m4400constructorimpl(4)) != 0) {
                return true;
            }
        }
        return true;
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            if (it.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                it.clearSubtreeIntrinsicsUsage$ui_release();
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            if (it.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                it.clearSubtreePlacementIntrinsicsUsage();
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            it.intrinsicsUsageByParent = it.previousIntrinsicsUsageByParent;
            if (it.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                it.resetSubtreeIntrinsicsUsage$ui_release();
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (!isAttached()) {
            throw new IllegalArgumentException("onReuse is only expected on attached node".toString());
        }
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        if (this.deactivated) {
            this.deactivated = false;
        } else {
            resetModifierState();
        }
        setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        this.deactivated = true;
        resetModifierState();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator delegate$iv = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate$iv, final$iv) && delegate$iv != null; delegate$iv = delegate$iv.getWrapped()) {
            NodeCoordinator it = delegate$iv;
            it.onRelease();
        }
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }
    }

    public static final int ZComparator$lambda$38(LayoutNode node1, LayoutNode node2) {
        if (node1.getZIndex() == node2.getZIndex()) {
            return Intrinsics.compare(node1.getPlaceOrder$ui_release(), node2.getPlaceOrder$ui_release());
        }
        return Float.compare(node1.getZIndex(), node2.getZIndex());
    }
}
