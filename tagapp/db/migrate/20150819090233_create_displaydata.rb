class CreateDisplaydata < ActiveRecord::Migration
  def change
    create_table :displaydata do |t|
      t.date :infodate
      t.integer :hour
      t.integer :positive
      t.integer :neutral
      t.integer :negative
      t.binary :cloud
      t.string :image_loc

      t.timestamps null: false
    end
  end
end
