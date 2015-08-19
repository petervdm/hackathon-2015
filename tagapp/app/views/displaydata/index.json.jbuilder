json.array!(@displaydata) do |displaydatum|
  json.extract! displaydatum, :id, :infodate, :hour, :positive, :neutral, :negative, :cloud, :image_loc
  json.url displaydatum_url(displaydatum, format: :json)
end
