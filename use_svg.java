
//gradle dependency
//compile 'org.mapsforge:svg-android:0.4.3'
public void setSVGIntoIamageView(ImageView img){
    SVG svg = null;
    try {
 	    svg = SVGParser.getSVGFromResource(getResources(), R.raw.logo);
        } catch (SVGParseException e) {
	    e.printStackTrace();
    	}
    img.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    Drawable drawable = svg.createPictureDrawable();
    img.setImageDrawable(drawable);                                       
}
