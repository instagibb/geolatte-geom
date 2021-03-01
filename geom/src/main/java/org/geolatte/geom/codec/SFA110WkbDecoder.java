package org.geolatte.geom.codec;

import org.geolatte.geom.ByteBuffer;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Position;
import org.geolatte.geom.crs.CoordinateReferenceSystem;

public class SFA110WkbDecoder implements WkbDecoder {


    @Override
    public <P extends Position> Geometry<P> decode(ByteBuffer byteBuffer, CoordinateReferenceSystem<P> crs) {
        BaseWkbParser<P> parser = new BaseWkbParser<>(SFA110WkbDialect.INSTANCE, byteBuffer, crs);
        try {
            return parser.parse();
        } catch( WkbDecodeException e) {
            throw e;
        } catch (Throwable e) {
            throw new WkbDecodeException(e);
        }
    }


}
