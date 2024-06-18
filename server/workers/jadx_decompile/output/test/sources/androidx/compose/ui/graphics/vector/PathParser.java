package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathParser.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0082\bJ\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0010H\u0082\bJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "()V", "floatResult", "Landroidx/compose/ui/graphics/vector/FloatResult;", "nodeData", "", "nodes", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "addNodes", "", "cmd", "", "args", "count", "", "addPathNodes", "", "clear", "parsePathString", "pathData", "", "resizeNodeData", "dataCount", "toNodes", "toPath", "Landroidx/compose/ui/graphics/Path;", "target", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PathParser {
    private final List<PathNode> nodes = new ArrayList();
    private final FloatResult floatResult = new FloatResult(0.0f, false, 3, null);
    private float[] nodeData = new float[64];

    public final void clear() {
        this.nodes.clear();
    }

    public final PathParser parsePathString(String pathData) {
        int index;
        Intrinsics.checkNotNullParameter(pathData, "pathData");
        this.nodes.clear();
        int start = 0;
        int end = pathData.length();
        int dataCount = 0;
        while (start < end && Intrinsics.compare((int) pathData.charAt(start), 32) <= 0) {
            start++;
        }
        while (end > start && Intrinsics.compare((int) pathData.charAt(end - 1), 32) <= 0) {
            end--;
        }
        int index2 = start;
        while (index2 < end) {
            char command = 0;
            while (true) {
                index = index2 + 1;
                char c = pathData.charAt(index2);
                int lowerChar = c | ' ';
                if ((lowerChar - 97) * (lowerChar - 122) <= 0 && lowerChar != 101) {
                    command = c;
                    break;
                }
                if (index >= end) {
                    break;
                }
                index2 = index;
            }
            if (command == 0) {
                index2 = index;
            } else {
                if ((command | ' ') != 122) {
                    dataCount = 0;
                    while (true) {
                        if (index >= end || Intrinsics.compare((int) pathData.charAt(index), 32) > 0) {
                            int index3 = FastFloatParser.INSTANCE.nextFloat(pathData, index, end, this.floatResult);
                            if (!this.floatResult.getIsValid()) {
                                index = index3;
                            } else {
                                int dataCount2 = dataCount + 1;
                                this.nodeData[dataCount] = this.floatResult.getValue();
                                if (dataCount2 >= this.nodeData.length) {
                                    float[] src$iv = this.nodeData;
                                    this.nodeData = new float[dataCount2 * 2];
                                    ArraysKt.copyInto(src$iv, this.nodeData, 0, 0, src$iv.length);
                                }
                                index = index3;
                                dataCount = dataCount2;
                            }
                            while (index < end && pathData.charAt(index) == ',') {
                                index++;
                            }
                            if (index >= end || !this.floatResult.getIsValid()) {
                                break;
                            }
                        } else {
                            index++;
                        }
                    }
                }
                index2 = index;
                float[] args$iv = this.nodeData;
                PathNodeKt.addPathNodes(command, this.nodes, args$iv, dataCount);
            }
        }
        return this;
    }

    private final void resizeNodeData(int dataCount) {
        if (dataCount >= this.nodeData.length) {
            float[] src = this.nodeData;
            this.nodeData = new float[dataCount * 2];
            ArraysKt.copyInto(src, this.nodeData, 0, 0, src.length);
        }
    }

    public final PathParser addPathNodes(List<? extends PathNode> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        this.nodes.addAll(nodes);
        return this;
    }

    public final List<PathNode> toNodes() {
        return this.nodes;
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    public final Path toPath(Path target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return PathParserKt.toPath(this.nodes, target);
    }

    private final void addNodes(char cmd, float[] args, int count) {
        PathNodeKt.addPathNodes(cmd, this.nodes, args, count);
    }
}
