package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageLoader {
	private String db_url = "jdbc:postgresql://cloudproj.ct233hyipvfx.us-east-1.rds.amazonaws.com:5432/elandb";
	private String username = "elan";
	private String password = "Indulgence";
	Random rand = new Random();
	private String basePath;
	private static final int SAREE = 1;
	private static final int LEHENGAS = 2;
	private static final int KURTIS = 3;
	private static final int SALWAR_KAMEEZ = 4;
	private static final int DRESSES = 5;
	private static final int JEWELLERY = 6;
	private static final int BAGS = 7;
	private static final int FOOTWEAR = 8;
	private static final int SCARVES = 9;
	private static final int SHERWANI = 10;
	private static final int KURTAS = 11;
	private static final int SUITS = 12;
	private static final int ETHNIC_GIRLS = 13;
	private static final int FROCKS = 14;
	private static final int ETHNIC_BOYS = 15;
	private static final int SLIDES = 16;
	private static final int CLUTCHES = 17;
	private static final int EARRINGS = 18;
	private static final int SHOES = 19;
	private static final int STOLE = 20;
	
	
	private static final int ANITA_REDDY = 1;
	private static final int BHARGAVAI_KUNAM = 2;
	private static final int PAWAN_PRANAV = 3;
	private static final int SRIDEVI_SWAPNA = 4;
	private static final int VARUNI_GOPEN = 5;
	private static final int BHAMINEE = 6;
	private static final int MANYA = 7;
	private static final int POLKA_DOTS = 8;
	private static final int SAMYAKK = 9;
	private static final int OTHER = 9;
	private static final int MANYA_COLLEC = 10;
	private static final int SANVI= 11;

	private static final int RED = 1;
	private static final int BLUE = 2;
	private static final int GREEN = 3;
	private static final int BLACK = 4;
	private static final int YELLOW = 5;
	private static final int SILVER = 6;
	private static final int GOLD = 7;
	private static final int PURPLE = 8;
	private static final int PINK = 9;
	private static final int ORANGE = 10;
	private static final int CREAM = 11;
	private static final int WHITE = 12;
	private static final int GREY = 13;
	private static final int BROWN = 14;

	public static int CURRENT_ID = 1;
	

	public ImageLoader(String path) {
		this.basePath = path;
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Input image folders path");
			System.exit(-1);
		}
		String path = args[0];
		ImageLoader loader = new ImageLoader(path);
		try {
			loader.loadImagesToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadImagesToDB() throws Exception {
		Connection conn = initializeConnection();
		PreparedStatement insertImage = conn.prepareStatement("INSERT INTO images VALUES (?,?)");
		PreparedStatement addProduct = conn.prepareStatement("INSERT INTO products VALUES(?,?,?,?,?,?,?)");
		PreparedStatement addColors = conn.prepareStatement("INSERT INTO product_color VALUES(?,?)");
		try {
		File baseImagesFolder = new File(basePath);
		if (baseImagesFolder.isDirectory()) {
			File[] subFolders = baseImagesFolder.listFiles();
			for (File folder : subFolders) {
				File[] merchants = folder.listFiles();
				for (File merchant : merchants) {
					String merchantName = merchant.getName();

					System.out.println("Merchant Name: "+merchantName);
					int merchantId = getmerchantID(merchantName);
					File[] productTypes = merchant.listFiles();
					for (File productType : productTypes) {
						String type = productType.getName();
						System.out.println("Product Type: "+type);
						int typeId = getProductTypeID(type);
						File[] files = productType.listFiles();
						for (File file : files) {
							List<String> colors = new ArrayList<String>();
							String name=file.getName();
							System.out.println(name);
							String[] arr=name.split("\\.");
							name=arr[0];
							String[] colorString = name.split("_");
							if (colorString.length > 1) {
								for (int i = 1; i < colorString.length; i++) {
									colors.add(colorString[i]);
								}
							}
							FileInputStream fis = null;
							try {
								fis = new FileInputStream(file);
								insertImage.setInt(1, CURRENT_ID);
								insertImage.setBinaryStream(2, fis, file.length());
								insertImage.executeUpdate();
								//insertImage.addBatch();
								for (String color : colors) {
									int colorid = getColorID(color);
									if(colorid!=-1){
									addColors.setInt(1, CURRENT_ID);
									addColors.setInt(2, colorid);
									addColors.addBatch();}
								}
								addProduct.setInt(1, CURRENT_ID);
								addProduct.setInt(2, CURRENT_ID);
								addProduct.setInt(3, typeId);
								addProduct.setInt(4, merchantId);
								addProduct.setInt(5, rand.nextInt(20));
								addProduct.setFloat(6, getRandomRating());
								addProduct.setDate(7, new Date(new java.util.Date().getTime()));
								addProduct.addBatch();
								CURRENT_ID++;
								Thread.sleep(1000);
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								if (fis != null) {
									try {
										fis.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
							
						}
					}
				}
			}
			//insertImage.executeBatch();
			addProduct.executeBatch();
			addColors.executeBatch();
		} else {
			System.out.println("Enter valid folder path");
			System.exit(-1);
		}
		} catch(Exception e){
			e.printStackTrace();
			
		}finally {
			if (conn != null) {
				conn.close();
			} 
			if (insertImage != null) {
				insertImage.close();
			}
			if (addProduct != null) {
				addProduct.close();
			}
			if (addColors != null) {
				addColors.close();
			}
		}
	}

	private float getRandomRating() {
		float min = 0.0f;
		float max = 5.0f;
		return rand.nextFloat() * (max - min) + min;
	}

	private int getColorID(String color) throws Exception {
		if (color.equalsIgnoreCase("red")) {
			return RED;
		} else if (color.equalsIgnoreCase("blue")) {
			return BLUE;
		} else if (color.equalsIgnoreCase("green")) {
			return GREEN;
		} else if (color.equalsIgnoreCase("black")) {
			return BLACK;
		} else if (color.equalsIgnoreCase("yellow")) {
			return YELLOW;
		} else if (color.equalsIgnoreCase("silver")) {
			return SILVER;
		} else if (color.equalsIgnoreCase("gold")) {
			return GOLD;
		} else if (color.equalsIgnoreCase("purple")) {
			return PURPLE;
		} else if (color.equalsIgnoreCase("pink")) {
			return PINK;
		} else if (color.equalsIgnoreCase("orange")) {
			return ORANGE;
		} else if (color.equalsIgnoreCase("cream")) {
			return CREAM;
		} else if (color.equalsIgnoreCase("white")) {
			return WHITE;
		} else if (color.equalsIgnoreCase("grey")) {
			return GREY;
		} else if (color.equalsIgnoreCase("brown")) {
			return BROWN;
		} 
		return -1;
		//throw new Exception(color);
	}

	private int getmerchantID(String merchantName) throws Exception {
		if (merchantName.equalsIgnoreCase("anitha_reddy")) {
			return ANITA_REDDY;
		} else if (merchantName.equalsIgnoreCase("bhargavi_kunam")) {
			return BHARGAVAI_KUNAM;
		} else if (merchantName.equalsIgnoreCase("pawan_pranav")) {
			return PAWAN_PRANAV;
		} else if (merchantName.equalsIgnoreCase("sridevi_swapna")) {
			return SRIDEVI_SWAPNA;
		} else if (merchantName.equalsIgnoreCase("varuni_gopen")) {
			return VARUNI_GOPEN;
		} else if (merchantName.equalsIgnoreCase("bhaminee")) {
			return BHAMINEE;
		} else if (merchantName.equalsIgnoreCase("manya")) {
			return MANYA;
		} else if (merchantName.equalsIgnoreCase("polka_dots")) {
			return POLKA_DOTS;
		} else if (merchantName.equalsIgnoreCase("samyakk")) {
			return SAMYAKK;
		} else if (merchantName.equalsIgnoreCase("other")) {
			return OTHER;
		}else if (merchantName.equalsIgnoreCase("manya_collections")) {
			return MANYA_COLLEC;
		} else if (merchantName.equalsIgnoreCase("sanvi")) {
			return SANVI;
		} 
		throw new Exception(merchantName);
	}

	private int getProductTypeID(String type) throws Exception {
		if (type.equalsIgnoreCase("sarees")) {
			return SAREE;
		} else if (type.equalsIgnoreCase("lehengas")) {
			return LEHENGAS;
		} else if (type.equalsIgnoreCase("salwar")) {
			return SALWAR_KAMEEZ;
		} else if (type.equalsIgnoreCase("kurtis")) {
			return KURTIS;
		} else if (type.equalsIgnoreCase("dress")) {
			return DRESSES;
		} else if (type.equalsIgnoreCase("sherwani")) {
			return SHERWANI;
		} else if (type.equalsIgnoreCase("kurtas")) {
			return KURTAS;
		} else if (type.equalsIgnoreCase("suits")) {
			return SUITS;
		}  else if (type.equalsIgnoreCase("jewellery")) {
			return JEWELLERY;
		} else if (type.equalsIgnoreCase("bags")) {
			return BAGS;
		} else if (type.equalsIgnoreCase("scarves")) {
			return SCARVES;
		} else if (type.equalsIgnoreCase("footwear")) {
			return FOOTWEAR;
		} else if (type.equalsIgnoreCase("ethnic_girls")) {
			return ETHNIC_GIRLS;
		} else if (type.equalsIgnoreCase("dress_girls")) {
			return FROCKS;
		} else if (type.equalsIgnoreCase("ethnic_boys")) {
			return ETHNIC_BOYS;
		}else if (type.equalsIgnoreCase("slides")) {
			return SLIDES;
		}else if (type.equalsIgnoreCase("clutches")) {
			return CLUTCHES;
		}else if (type.equalsIgnoreCase("earrings")) {
			return EARRINGS;
		}else if (type.equalsIgnoreCase("shoes")) {
			return SHOES;
		}else if (type.equalsIgnoreCase("stole")) {
			return STOLE;
		}
		throw new Exception(type);
		
	}

	private Connection initializeConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		Connection conn = null;
		try {
			while (conn == null) {
				conn = DriverManager.getConnection(db_url, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
